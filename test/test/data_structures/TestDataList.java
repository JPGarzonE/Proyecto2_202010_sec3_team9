package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import model.data_structures.DataList;
import model.data_structures.DataNode;

public class TestDataList {

	private DataList<Object> dataList;
	private DataNode<Object> node;
	
	public void setUp1()
	{
		dataList = new DataList<Object>();
	}
	
	
	public void testGetSize()
	{
		setUp1();
		
		assertTrue("El tama�o debe ser mayor a cero", dataList.getSize()>0 );
		assertEquals( "El tama�o deber�a ser 150", 150, dataList.getSize() );
	}

	public void testAddNode()
	{
		setUp1();
		
		assertEquals( "No deben existir nodos", 0, dataList.getSize() );
        try
        {
            dataList.addNode( node );
            assertEquals( "Deber�a existir 1 nodo", 1, dataList.getSize());
        }
        catch (Exception e)
        {
        	fail("Deberia existir al menos un nodo");
        }
	}

	public void testGetFirstNode() 
	{
		setUp1();
		try
        {
            dataList.getFirstNode();
            fail( "No deber�a encontrar un nodo" );
        }
        catch( Exception e1 ){	
        }

        try
        {
            assertNull( "El anterior deberia ser null", node.getPrevious() );
        }
        catch( Exception e2 )
        {
            fail( "El anterior no es null" );
        }
	}

	public void testGetLastNode() 
	{
		setUp1();
		try
        {
            dataList.getLastNode();
            fail( "No deber�a encontrar una l�nea de producto" );
        }
        catch( Exception e1 ){
        }

        try
        {
            assertNull( "El siguiente deberia ser null", node.getNext());
        }
        catch( Exception e2 )
        {
            fail( "El siguiente no es null" );
        }
	}

}
