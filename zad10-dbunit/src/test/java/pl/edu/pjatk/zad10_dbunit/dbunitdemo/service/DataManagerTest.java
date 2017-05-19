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
import pl.edu.pjatk.zad10_dbunit.service.DataManager;
import pl.edu.pjatk.zad10_dbunit.service.DataManagerImpl;

import java.net.URL;
import java.sql.SQLException;

@RunWith(JUnit4.class)
public class DataManagerTest extends DBTestCase {
	DataManager dataManager;

    public DataManagerTest() throws Exception {
        super("DataManagerImpl test");
    }

    protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.INSERT;
    }

    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.NONE;
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
    	System.out.println("ASLDASDASD ------------------");
        super.setUp();
        dataManager = new DataManagerImpl(this.getConnection().getConnection());
    }
	
	@Test
	public void checkAdding() throws Exception {
		DataObject data = new DataObject();
		data.setColor("Retarded Purple");
		data.setCurrency("DESKI HEBANOWE");
		data.setIban("ud2a3fvtcvab3y");

		assertEquals(1, dataManager.addData(data));

        // Data verification
		System.out.println("CHECK ADDING ------------------");

        IDataSet dbDataSet = this.getConnection().createDataSet();
        ITable actualTable = dbDataSet.getTable("MOCK_DATA");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
                (actualTable, new String[]{"ID"});
        IDataSet expectedDataSet = getDataSet("dataset-pm-add-check.xml");
        ITable expectedTable = expectedDataSet.getTable("MOCK_DATA");

        Assertion.assertEquals(expectedTable, filteredTable);
    }
	
}
