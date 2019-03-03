CRC Cards:

1. Customer
	Responsibilities:
		Name
		Cell Phone Number
		Number of People (Party Size)
		Sign up on a waitlist
			- Send Name, Cell Phone Number and Party Size information
		Send “STOP” message to stop receiving messages and leave the queue
		Send Response upon receiving “Table Ready” message
			- Send “Confirm” to accept the table
			- Send “Leave” to leave the wait queue

	Collaborators:
		Communication

2. WaitListManager
	Responsibilities:
		Manages wait list queue
		Adds customer on waitlist at the end of queue
		Removes customer from Waitlist upon receiving "Confirm" or “Leave” message

	Collaborators:
		Customer

3. Communication
	Responsibilities:
		Pass the received information from Customer to WaitListManager
		Send a text message to customer once customer is registered on waitlist
		Send “Table Ready” message to customer when table is ready to confirm or leave the waitlist
		Notifies WaitListManager whether customer has chosen to confirm the waitlist or leave the waitlist
		Notifies CustomerHandler1 whether customer has chosen to confirm the waitlist or leave the waitlist
		Notifies CustomerHandler2 whether customer has chosen to confirm the waitlist or leave the waitlist

	Collaborators:
		Customer, WaitListManager, CustomerHandler1, CustomerHandler2

4. Table
	Responsibilities:
		Table Size

5. TableManager
	Responsibilities:
		Checks if table is available
			- If table is available, TableManager figures out the size of that table
		Notifies CustomerHandler1 to assign the available table to the next available party

	Collaborators:
		Table, CustomerHandler1

6. CustomerHandler1
	Responsibilities:
		Knows next available table and size of that table
		Asks WaitListManager about the next party in the front of the line
		Asks Communication to send Customer a “Table Ready” notification
		If customer chooses to confirm:
			- Assign the available table to the customer
		If customer chooses to leave:
			- send available table information to CustomerHandler2
			- asks CustomerHandler2 to find the next available party
		If available table cannot accommodate next available party
			- send available table information to CustomerHandler2
			- asks CustomerHandler2 to find the next available party


	Collaborators:
		Customer, Communication, WaitListManager, CustomerHandler2

7. CustomerHandler2
	Responsibilities:
		Knows next available table and size of that table
		Find the next available party that can fit into the table size
		If customer chooses to leave:
			- Find the next available party that current available table can accommodate
		If customer chooses to confirm:
			- Assign the available table to the customer

	Collaborators:
		Customer, WaitListManager

******************************************************************************************************

Pattern Explanation:

There are two patterns I have used here in my CRC cards:

1. Observer pattern:
	TableManager plays a "Subject" role and CustomerHandler1 plays an "Observer" role. CustomerHandler1's job is to assign the table to the next available party. Therefore, when the table becomes available, CustomerHandler1 needs to be notified that the table is available and CustomerHandler1 can assign it to the next available party. CustomerHandler1 waits for the notification of "Table is available" to start its work. Therefore, I have used observer pattern.

2. Chain of responsibility:
	CustomerHandler1 and CustomerHandler2 are two classes which implement this pattern. When CustomerHandler1 looks for the next available party but couldn't find one, it passes this responsibility to its successor which is CustomerHandler2. CustomerHandler2 then starts to find the next suitable party which can be accommodated in the available table.