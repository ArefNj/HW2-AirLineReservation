
<h1 >Advance Programming<br>
Yazd University
</h1>

**Teacher: Dr.Shokoofeh Bostan**

TAs: [Mohsen Gholami](https://about.me/iMohsen02) - [Pooria Azami](https://github.com/pooriaazami)

---

**AIRLINES RESERVATION SYSTEM**


This project aims to simulate the online reservation system of airline tickets in a console application (non-graphics). The airline reservations System contains airline schedules, passenger reservations, and ticket records. This system includes two types of users like passengers, and system administrator.

```
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
           WELCOME TO AIRELINE RESERVATION SYSTEM
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
..........................MENU OPTIONS........................

    <1> Sign in
    <2> Sign up 
```
Use your Account to sign in or create new one. The admin user is pre-defined with a fixed username and password (Admin).

Admin User:
After admin login, the guidance commands display:

```
::::::::::::::::::::::::::::::::::::::::
           Admin MENUE OPTIONS
::::::::::::::::::::::::::::::::::::::::
 ......................................
    <1> Add
    <2> Update
    <3> Remove
    <4> Flight schedules
    <0> Sign out
```

The admin is able to add, update or remove flight details. The flight schedule includes the following:

```
|FlightId   |Origin     |Destination  |Date        |Time       |Price      |Seats |
...................................................................................
|WX-12      |Yazd       |Tehran       |1401-12-10  |12:30      |700,000    |51    |
...................................................................................
|WX-15      |Mashhad    |Ahvaz        |1401-12-11  |08:00      |900,000    |245   |
...................................................................................
|BG-22      |Shiraz     |Tabriz       |1401-12-12  |22:30      |1,100,000  |12    |
...................................................................................
```

Seat refers to available seats that are reduced by booking a ticket.

Other Users:
After creating your account as a new passenger, and sign in, the guidance menu options display as follows:
```
::::::::::::::::::::::::::::::::::::::::
         PASSENGER MENU OPTIONS
::::::::::::::::::::::::::::::::::::::::
 ......................................
    <1> Change password
    <2> Search flight tickets
    <3> Booking ticket
    <4> Ticket cancelation
    <5> Booked tickets
    <6> Add charge
    <0> Sign out
```

- Filter tickets based on flight id, origin, destination, date, time, price range, or some of them in “Search flight tickets” mode.
- The “Booking ticket” mode is based on flight id. By booking each ticket, a unique code is generated as a ticket id.
- The “ticket cancellation” process by each ticket id would be confirmed and the refund would be credited back to the account(charge).
- The “Booked tickets” mode includes all reserved tickets of the user.
- Users have a charging section in their profile where they enter the desired amount.
(“Add charge”). Every time a ticket is booked, the ticket amount is deducted from this charge.

**Note:**
1. The tickets have been booked as "one-way" and “Single” for convenience. Also, the type of flight has been omitted.
2. you can book tickets If the charge is enough.
3. In each step, after completing the process, it will be back to the last menu options.
4. Sign out and back to the login menu using zero code<0>.
5. The program is never stop and your data will not be deleted Even if you log out.
