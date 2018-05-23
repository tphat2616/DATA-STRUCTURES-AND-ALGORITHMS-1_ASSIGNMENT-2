package tdt.algo;

public class MyCompanyMgrList extends CompanyMgrList {	
	// you can add some more member variable if you need.
	
	public MyCompanyMgrList()
	{
		super();
	}
	
	/*********************************************************************************************/
	// you can add some more methods if you need.
	
	private int getEventCode(eventList pEvent)
	{
		// code here
		return 0;
	}

	private int getProductId(int nEvent)
	{
		// code here
		return 0;
	}

	/**
	 * get quantity fron nEventCode of eventList
	 */
	private int getQuan(int nEvent)
	{
		// code here
		return 0;
	}

	/**
	 * add a new noteList add the end of linked-list notesList
	 * tail:  pointer to tail of head of notesList
	 * side-effec: tail point to the new node which is now the tail
	 */
	private void doImport(int nEventCode)
	{
		// code here
	}

	/**
	 * add a new noteList add the end of linked-list notesList
	 * tail:  pointer to tail of head of notesList
	 * side-effec: tail point to the new node which is now the tail
	 */
	private void doReserve(int nEventCode)
	{
		// code here
	}
	
	/**
	 * stats and delete IMPORTED product with code in nEventCode,
	 * side-effect: head, tail change
	 */
	private void doStatImport(int nEventCode)
	{
		// code here
	}

	private void doStatReserve(int nEventCode)
	{
		// code here
	}

	private void doStatRest(int nEventCode)
	{
		// code here
	}

	/**
	 *
	 * find Product with Max Rest in storage
	 */

	private void doMaxRestStat()
	{
		// code here
	}

	private void doRemoveInvalidReserve()
	{
		// code here
	}
	
	public boolean checkPalindrome()
	{
		// code here
		return false;
	}

	public void storage (notesList theFirst, eventList pEvent)
	{
		// code here
		head = new notesList();
		head.setnProdID(theFirst.getnProdID());
		head.setnQuan(theFirst.getnQuan());
		head.setnType(theFirst.getnType());
		head.setNext(null);
		tail = head;

		while(pEvent != null)
		{
			switch(getEventCode(pEvent))
			{
				case eventList.TERMINATE_EVENT:
					return;
				case eventList.IMPORT_EVENT:
					doImport(pEvent.getnEventCode());
					break;
				case eventList.RESERVED_EVENT:
					doReserve(pEvent.getnEventCode());
					break;
				case eventList.STAT_IMPORT_EVENT:
					doStatImport(pEvent.getnEventCode());
					break;
				case eventList.STAT_RESERVED_EVENT:
					doStatReserve(pEvent.getnEventCode());
					break;
				case eventList.STAT_REST_EVENT:
					doStatRest(pEvent.getnEventCode());
					break;
				case eventList.MAX_REST_STAT_EVENT:
					doMaxRestStat();
					break;
				case eventList.REMOVE_INVALID_RESERVE_EVENT:
					doRemoveInvalidReserve();
					break;
				default:
			}

			pEvent = pEvent.getNext();

			if(head == null)
				break;
		}
	}
}