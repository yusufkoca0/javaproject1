how to compile and run:
>javac Main.java
>java Main people.txt films.txt commands.txt output.txt

people.txt layout:

DIRECTOR:<tab><ID><tab><NAME><tab><SURNAME><tab><COUNTRY><tab><AGENT>

WRITER:<tab><ID><tab><NAME><tab><SURNAME><tab><COUNTRY><tab><TYPE>

ACTOR:<tab><ID><tab><NAME><tab><SURNAME><tab><COUNTRY><tab><HEIGHT>

CHILDACTOR:<tab><ID><tab><NAME><tab><SURNAME><tab><COUNTRY><tab><AGE>

STUNTPERFORMER:<tab><ID><tab><NAME><tab><SURNAME><tab><COUNTRY><tab><HEIGHT><tab>
<ACTOR1ID,...,ACTORnID>

USER:<tab><ID><tab><NAME><tab><SURNAME><tab><COUNTRY>

films.txt layout:

FeatureFilm:<tab><ID><tab><TITLE><tab><LANGUAGE><tab><DIRECTOR1ID,..,DIRECTORnID>
<tab><LENGTH><tab><COUNTRY><tab><PERFORMER1ID,..,PERFORMERnID><tab><GENRE1,...,
GENREn><tab><RELEASEDATE><tab><WRITER1ID,...,WRITERnID><tab><BUDGET>

ShortFilm:<tab><ID><tab><TITLE><tab><LANGUAGE><tab><DIRECTOR1ID,...,DIRECTORnID>
<tab><LENGTH><tab><COUNTRY><tab><PERFORMER1ID,...,PERFORMERnID><tab><GENRE1,...,
GENREn><tab><RELEASEDATE><tab><WRITER1ID,...,WRITERnID>

Documentary:<tab><ID><tab><TITLE><tab><LANGUAGE><tab><DIRECTOR1ID,...,<DIRECTORnID>
<tab><LENGTH><tab><COUNTRY><tab><PERFORMER1ID,...,PERFORMERnID><tab><RELEASEDATE>

TVSeries:<tab><ID><tab><TITLE><tab><LANGUAGE><tab><DIRECTOR1ID,...,DIRECTORnID>
<tab><LENGTH><tab><COUNTRY><tab><PERFORMER1ID,...,PERFORMERnID><tab><GENRE1,...,
GENREn><tab><WRITER1ID,...,WRITERnID><tab><STARTDATE><tab><ENDDATE><tab><SEASONS>
<tab><EPISODES>

commands.txt commands:

RATE<tab><USERID><tab><FILMID><tab><RATINGPOINT>

ADD<tab>FEATUREFILM<tab><ID><tab><TITLE><tab><LANGUAGE><tab>
<DIRECTOR1ID,..., DIRECTORnID><tab><LENGTH><tab><COUNTRY><tab>
<PERFORMER1ID,...,PERFORMERnID> <tab><GENRE1,...,GENREn><tab>
<RELEASEDATE><tab><WRITER1ID,...,WRITERnID><tab> <BUDGET>

VIEWFILM<tab><FILMID>

LIST<tab>USER<tab><USERID><tab>RATES

EDIT<tab>RATE<tab><USERID><tab><FILMID><tab><NEWRATINGPOINT>

REMOVE<tab>RATE<tab><USERID><tab><FILMID>

LIST<tab>FILM<tab>SERIES

LIST<tab>FILMS<tab>BY<tab>COUNTRY<tab><COUNTRY>

LIST<tab>FEATUREFILMS<tab>BEFORE<tab><YEAR>

LIST<tab>FEATUREFILMS<tab>AFTER<tab><YEAR>

LIST<tab>FILMS<tab>BY<tab>RATE<tab>DEGREE

LIST<tab>ARTISTS<tab>FROM<tab><COUNTRY>
