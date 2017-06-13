package pl.edu.pjatk.zad10_dbunit.dbunitdemo.service;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.edu.pjatk.zad10_dbunit.domain.DataObject;
import pl.edu.pjatk.zad10_dbunit.domain.Person;
import pl.edu.pjatk.zad10_dbunit.service.DataManager;
import pl.edu.pjatk.zad10_dbunit.service.DataManagerImpl;
import pl.edu.pjatk.zad10_dbunit.service.PersonManager;
import pl.edu.pjatk.zad10_dbunit.service.PersonManagerImpl;

import java.net.URL;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

@RunWith(JUnit4.class)
public class RelationTest extends DBTestCase {
	DataManager dataManager;
	PersonManager personManager;

    public RelationTest() throws Exception {
        super("RELATION test");
    }

    protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.INSERT;
    }

    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.TRUNCATE_TABLE;
    }

    /**
     * Gets the default dataset. This dataset will be the initial state of database
     * @return the default dataset
     * @throws Exception when there are errors getting resources
     */
    @Override
    protected IDataSet getDataSet() throws Exception {
        return this.getDataSet("dataset-pm-add.xml");
    }

    /**
     * Returns dataset for selected resource
     * @param datasetName filename in resources
     * @return flat xml data set
     * @throws Exception when there is a problem with opening dataset
     */
    protected IDataSet getDataSet(String datasetName) throws Exception {
        URL url = getClass().getClassLoader().getResource(datasetName);
        FlatXmlDataSet ret = new FlatXmlDataSetBuilder().build(url.openStream());
        return ret;
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        dataManager = new DataManagerImpl(this.getConnection().getConnection());
        personManager = new PersonManagerImpl(this.getConnection().getConnection());
    }
	
	
	@Test
	public void findDataObjectsPeople() throws Exception {
		DatabaseOperation.CLEAN_INSERT.execute(this.getConnection(), getDataSet("dataset-rl.xml"));
		String name1="Genowefa", name2="Janusz";
		Person tmpPerson1, tmpPerson2;
		DataObject tmpDataObject;
		tmpDataObject = dataManager.getDataByColor("Red");
		tmpPerson1 = personManager.getPersonByName(name1);
		tmpPerson1.setDataObject_id(tmpDataObject.getId());
		personManager.updatePerson(tmpPerson1);
		
		tmpPerson2 = personManager.getPersonByName(name2);
		tmpPerson2.setDataObject_id(tmpDataObject.getId());
		personManager.updatePerson(tmpPerson2);
		


		List<Person> peopleAssignedToRed = personManager.getPersonByDataObjectId(tmpDataObject.getId());
		
		assertEquals(2, peopleAssignedToRed.size());
		
		/*peopleAssignedToRed.sort(new Comparator<Person>() {
		@Override
		public int compare(Person p1, Person p2) {
			 return p1.getName().compareTo(p2.getName());}});*/

		assertEquals(name1, peopleAssignedToRed.get(0).getName());
		assertEquals(name2, peopleAssignedToRed.get(1).getName());
	
    }
	
}
