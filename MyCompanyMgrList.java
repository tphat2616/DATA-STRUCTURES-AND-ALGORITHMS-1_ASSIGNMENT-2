package java1_btl2;

public class MyCompanyMgrList extends CompanyMgrList {	
	// you can add some more member variable if you need.
	
	public MyCompanyMgrList()
	{
		super();
	}
	
	/*********************************************************************************************/
	// you can add some more methods if you need.
	
	
		
	public void addFirst(notesList a)
	{
		if(head ==null) 
		{
			
			head=a;
			tail=head;
		}
		
		else
		{
			a.setNext(head);
			head=a;
		}
	}
	public void addLast (notesList a)
	{
		if(head ==null) 
		{
			
			head=a;
			tail=head;
		}
		
		else
		{
			tail.setNext(a);
			tail=a;
		}
	}
	public notesList removeFirst(notesList a)
	{
		if ( head == null ) return null;
		else if ( tail == head ) {
		
			head = null;
			return tail;
		}
		else if(head!=tail){
		a = head;
		head = head.getNext();
		return a;}
		return null;
	}
	public notesList removeLast(notesList a)
	{
		notesList b;
		if ( head == null )	return null;
		if ( head == tail ){
			head = null;
			return tail;}
		if(head!=tail)
		{
			a = head;
		  b= tail;
		
		while ( a.getNext() != tail && a.getNext() != null )
			{a = a.getNext();}
		a.setNext( null );		
		tail = a;
		return b;
		}
		return null;
	}
	

	
	private int getEventCode(eventList pEvent)
	{
		// code here
		
		if (pEvent.getnEventCode() / 10000 == 1)
		{
			return 1;
		}
		else if (pEvent.getnEventCode() / 10000 == 2)
		{
			return 2;
		}
		else if (pEvent.getnEventCode() / 1000 == 3)
		{
			return 3;
		}
		else if (pEvent.getnEventCode() / 1000 == 4)
		{
			return 4;
		}
		else if (pEvent.getnEventCode() / 1000 == 5)
		{
			return 5;
		}
		else if (pEvent.getnEventCode()  == 6)
		{
			return 6;
		}
		else if (pEvent.getnEventCode()  == 8)
		{
			return 8;
		}
		else
		{
			return 0;
		}
	}

	private int getProductId(int nEvent)
	{
		// code here
		int ID = 0;
		if (nEvent / 10000 == 1){
			ID = (nEvent / 10) % 1000;
		}
		else if (nEvent / 10000 == 2){
			ID = (nEvent / 10) %1000;
		}
		else if (nEvent / 1000 == 3){
			ID = nEvent % 1000;
		}
		else  if (nEvent / 1000 == 4){
			ID = nEvent % 1000;
		}
		else if (nEvent / 1000 == 5){
			ID = nEvent % 1000;
		}
		
		
		return ID;
	}

	/**
	 * get quantity front nEventCode of eventList
	 */
	private int getQuan(int nEvent)
	{
		// code here
		int quan=0;
		if(nEvent /10000 ==1){
			quan = nEvent % 10;
			
		}
		else if(nEvent / 10000 == 2){
			quan = nEvent % 10;
			
		}
		
		
		return quan;
		
		
	}

	/**
	 * add a new noteList add the end of linked-list notesList
	 * tail:  pointer to tail of head of notesList
	 * side-effect: tail point to the new node which is now the tail
	 */
	private void doImport(int nEventCode)
	{
		// code here
		int nProID =(nEventCode / 10) % 1000;
		int nQuan =(nEventCode % 10);
		notesList note = new notesList(nProID, nQuan,1, null);
		addLast(note);
		
		
	    
		
	}

	/**
	 * add a new noteList add the end of linked-list notesList
	 * tail:  pointer to tail of head of notesList
	 * side-effect: tail point to the new node which is now the tail
	 */
	private void doReserve(int nEventCode)
	{
		// code here
		int nProID =(nEventCode / 10) % 1000;
		int nQuan =(nEventCode % 10);
		notesList note = new notesList(nProID, nQuan,2, null);
		addLast(note);
	}
	
	/**
	 * stats and delete IMPORTED product with code in nEventCode,
	 * side-effect: head, tail change
	 */
	private void doStatImport(int nEventCode)
	{
		// code here
		int sub=0;
		int ID=nEventCode % 1000;
		notesList note  = head;
		while(note!=null)
		{
			if(note.getnType()==1)
			{
				if(note.getnProdID()==ID)
				{
					sub=sub+note.getnQuan();
					if(sub>0)
					{
						if(note==head)
						{
							removeFirst(note);
							if(sub>99)
							{
								sub=sub%100;
							}
						}
						else if(note==tail)
						{
							removeLast(note);
							if(sub>99)
							{
								sub=sub%100;
							}
						}
						else 
						{
							notesList a = head;
							while ( a.getNext() != note && a.getNext() != null )
							{a = a.getNext();}
							a.setNext(note.getNext());
						
						}
					}
					
				}
				
			}
			note=note.getNext();
		}
		if ( sub > 0){
			notesList note1= new notesList(ID,sub,1);
			addFirst(note1);
		}
			
		else if ( sub == 0 )
		{
			notesList note2= new notesList(ID,sub,1);
			addLast(note2);
		}
	}

	private void doStatReserve(int nEventCode)
	{
		// code here
		int sub=0;
		int ID=nEventCode % 1000;
		notesList note  = head;
		while(note!=null)
		{
			if(note.getnType()==2)
			{
				if(note.getnProdID()==ID)
				{
					sub=sub+note.getnQuan();
					if(sub>0)
					{
						if(note==head)
						{
							removeFirst(note);
							if(sub>99)
							{
								sub=sub%100;
							}
						}
		
						else if(note==tail)
						{
							removeLast(note);
							if(sub>99)
							{
								sub=sub%100;
							}
						}
						else 
						{
							notesList a = head;
							while ( a.getNext() != note && a.getNext() != null )
							{a = a.getNext();}
							a.setNext(note.getNext());
							if(sub>99)
							{
								sub=sub%100;
							}
						
						}
					}
				}
			}
			note=note.getNext();
		}
		if(sub>0 || sub==0)
		{
			notesList note3= new notesList(ID,sub,2);
			addLast(note3);
		}
		
		
		
	}
	

	private void doStatRest(int nEventCode)
	{
		// code here
		int ID= nEventCode % 1000;
		int sum=0;
		notesList note = head;
		while(note!=null)
		{
			if(note.getnType()==1)
			{
				if(note.getnProdID()==ID)
				{
					sum=sum+note.getnQuan();
					if(note==head)
						{
							removeFirst(note);
							if(sum>99)
							{
								sum=sum%100;
							}
						}
		
						else if(note==tail)
						{
							removeLast(note);
							if(sum>99)
							{
								sum=sum%100;
							}
						}
						else 
						{
							notesList a = head;
							while ( a.getNext() != note && a.getNext() != null )
							{a = a.getNext();}
							a.setNext(note.getNext());
							if(sum>99)
							{
								sum=sum%100;
							}
						
						}
				}
			}
			note=note.getNext();
		}
		notesList c =head;
		while(c!=null)
		{
			if(c.getnType()==2)
			{
				if(c.getnProdID()==ID)
				{
					sum=sum-c.getnQuan();
					if(c==head)
						{
							removeFirst(c);
							if(sum>99)
							{
								sum=sum%100;
							}
							else if(sum<0)
							{
								sum=0;
							}
						}
		
						else if(c==tail)
						{
							removeLast(c);
							if(sum>99)
							{
								sum=sum%100;
							}
							else if(sum<0)
							{
								sum=0;
							}
						}
						else 
						{
							notesList a = head;
							while ( a.getNext() != c && a.getNext() != null )
							{a = a.getNext();}
							a.setNext(c.getNext());
							if(sum>99)
							{
								sum=sum%100;
							}
							else if(sum<0)
							{
								sum=0;
							}
						
						}
				}
			}
			c=c.getNext();
		}
		notesList note2 = new notesList(ID,sum,1);
		addLast(note2);
		
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