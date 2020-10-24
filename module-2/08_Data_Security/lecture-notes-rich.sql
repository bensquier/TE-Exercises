SELECT * FROM city WHERE district = 'New York';

//IN OUR CODE

//User: Enters City -> New York into variable cityName

"SELECT * FROM city WHERE district = '" + cityname + "';"

//User enters: New York

"SELECT * FROM city WHERE district = 'New York';"

//User is malicious
//User enters: New York' or 'a'='a

"SELECT * FROM city WHERE district = 'New York' or 'a'='a';"

//User is malicious and angry
//User enters: New York'; DELETE FROM city WHERE 'a'='a

"SELECT * FROM city WHERE district = 'New York'; DELETE FROM city WHERE 'a'='a';"

SELECT * FROM city WHERE (district = 'New York') or ('a'='a');

SELECT * FROM city WHERE (district = 'New York') or (true);

"SELECT * FROM city WHERE district = ?;"

"New York'; DELETE FROM city WHERE 'a'='a"

//How would they know?

//User attempts to enter a "broken string"

//User enters: New Y'ork

/*
"SELECT * FROM city WHERE district = '" + New Y'ork + "';"

"SELECT * FROM city WHERE district = 'New Y'ork';"
*/

//HASHING - ONE WAY!
Rich -> FEAB6923 FEsdfsd923 fgfg34sd 324sdfs

//IF EVERY HAS UNDER AN ALGORITHM IS THE SAME, HOW DO WE PREVENT A DICTIONARY ATTACK?

// SALT!

Rich + Salt = faf989 dsf8ds sdgsdf0 dgsfv086 09dsf sdfsdgfs

//ENCRYPTION - TWO WAY !! Yay
Rich -> FEAB6923FEsdfsd923fgfg34sd324sdfs
FEAB6923FEsdfsd923fgfg34sd324sdfs -> Rich

//HOW DOES ENCRYPTION WORK? PUBLIC AND PRIVATE KEYS
//... aka SYMETRIC OR ASYMETRIC ENCRYPTION

//SYMETRIC -> PUBLIC KEYS ARE SHARED
Rich -> public key:Bingo -> FEAB6923FEsdfsd923fgfg34sd324sdfs 
FEAB6923FEsdfsd923fgfg34sd324sdfs -> key:Bingo -> Rich

//ASYMETRIC -> PUBLIC KEYS HELD BY USERS, PRIVATE KEYS ARE RETAIN BY THE SERVER/APPLICATION
Rich -> public key:Bingo -> FEAB6923FEsdfsd923fgfg34sd324sdfs 
FEAB6923FEsdfsd923fgfg34sd324sdfs -> public key:Bingo -> FEAB6923FEsdfsd923fgfg34sd324sdfs (NO GOTS)
FEAB6923FEsdfsd923fgfg34sd324sdfs -> private key: yahtzee -> Rich (yay)

//MITM - Man In The Middle 


