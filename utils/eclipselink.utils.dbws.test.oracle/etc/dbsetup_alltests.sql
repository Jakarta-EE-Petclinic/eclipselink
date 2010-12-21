CREATE OR REPLACE PROCEDURE BOOL_IN_TEST (X IN BOOLEAN) AS
BEGIN
  NULL;
END BOOL_IN_TEST;
|
CREATE OR REPLACE PROCEDURE TESTECHO(T IN VARCHAR2, U OUT VARCHAR2) AS
BEGIN
  U := CONCAT('test-' , T);
END;
|
CREATE OR REPLACE PACKAGE SOMEPACKAGE AS
  TYPE TBL1 IS TABLE OF VARCHAR2(111) INDEX BY BINARY_INTEGER;
  TYPE TBL2 IS TABLE OF NUMBER INDEX BY BINARY_INTEGER;
  TYPE ARECORD IS RECORD (
    T1 TBL1,
    T2 TBL2,
    T3 BOOLEAN
  );
  TYPE TBL3 IS TABLE OF ARECORD INDEX BY PLS_INTEGER;
  TYPE TBL4 IS TABLE OF TBL2 INDEX BY PLS_INTEGER;
  PROCEDURE P1(SIMPLARRAY IN TBL1, FOO IN VARCHAR2);
  PROCEDURE P2(OLD IN TBL2, NEW IN TBL2);
  PROCEDURE P3(RECARRAY IN TBL3);
  PROCEDURE P4(REC IN ARECORD);
  PROCEDURE P5(OLDREC IN ARECORD, NEWREC OUT ARECORD);
  PROCEDURE P6(BAR IN TBL4);
END SOMEPACKAGE;
|
CREATE OR REPLACE PACKAGE BODY SOMEPACKAGE AS
  PROCEDURE P1(SIMPLARRAY IN TBL1, FOO IN VARCHAR2) AS
  BEGIN
    NULL;
  END P1;
  PROCEDURE P2(OLD IN TBL2, NEW IN TBL2) AS
  BEGIN
    NULL;
  END P2;
  PROCEDURE P3(RECARRAY IN TBL3) AS
  BEGIN
    NULL;
  END P3;
  PROCEDURE P4(REC IN ARECORD) AS
  BEGIN
    NULL;
  END P4;
  PROCEDURE P5(OLDREC IN ARECORD, NEWREC OUT ARECORD) AS
  BEGIN
    NEWREC.T1 := OLDREC.T1;
    NEWREC.T2 := OLDREC.T2;
    NEWREC.T3 := OLDREC.T3;
  END P5;
  PROCEDURE P6(BAR IN TBL4) AS
  BEGIN
    NULL;
  END P6;
END SOMEPACKAGE;
|
CREATE OR REPLACE TYPE SOMEPACKAGE_TBL1 AS TABLE OF VARCHAR2(111)|
CREATE OR REPLACE TYPE SOMEPACKAGE_TBL2 AS TABLE OF NUMBER|
CREATE OR REPLACE TYPE SOMEPACKAGE_ARECORD AS OBJECT (
  T1 SOMEPACKAGE_TBL1,
  T2 SOMEPACKAGE_TBL2,
  T3 INTEGER
)|
CREATE OR REPLACE TYPE SOMEPACKAGE_TBL3 AS TABLE OF SOMEPACKAGE_ARECORD|
CREATE OR REPLACE TYPE SOMEPACKAGE_TBL4 AS TABLE OF SOMEPACKAGE_TBL2|
CREATE OR REPLACE TYPE SOMEPACKAGE_CRECORD AS OBJECT (
  C1 SOMEPACKAGE_ARECORD,
  C2 SOMEPACKAGE_TBL2
)|
CREATE OR REPLACE TYPE SOMEPACKAGE_TBL5 AS TABLE OF DATE|
CREATE OR REPLACE FUNCTION SF_TBL1(NUM IN INTEGER) RETURN SOMEPACKAGE_TBL1 AS
    L_DATA SOMEPACKAGE_TBL1 := SOMEPACKAGE_TBL1();
  BEGIN
      FOR I IN 1 .. NUM LOOP
         L_DATA.EXTEND;
         L_DATA(I) := 'entry ' || i;
      END LOOP;
     RETURN L_DATA;
END;
|
CREATE OR REPLACE FUNCTION BUILDTBL2(NUM IN INTEGER) RETURN SOMEPACKAGE_TBL2 AS
    L_DATA SOMEPACKAGE_TBL2 := SOMEPACKAGE_TBL2();
    BEGIN
	FOR I IN 1 .. NUM LOOP
	 L_DATA.EXTEND;
	 L_DATA(I) := I;
	END LOOP;
    RETURN L_DATA;
END BUILDTBL2;
|
CREATE OR REPLACE FUNCTION BUILDTBL5(NUM IN INTEGER) RETURN SOMEPACKAGE_TBL5 AS
    L_DATA SOMEPACKAGE_TBL5 := SOMEPACKAGE_TBL5();
    BEGIN
	FOR I IN 1 .. NUM LOOP
	 L_DATA.EXTEND;
	 L_DATA(I) := SYSDATE;
	END LOOP;
    RETURN L_DATA;
END BUILDTBL5;
|
CREATE OR REPLACE FUNCTION BUILDARECORD(NUM IN INTEGER) RETURN SOMEPACKAGE_ARECORD AS
    L_DATA SOMEPACKAGE_ARECORD := SOMEPACKAGE_ARECORD(NULL, NULL, NULL);
    BEGIN
     L_DATA.T1 := SF_TBL1(NUM);
     L_DATA.T2 := BUILDTBL2(NUM);
     L_DATA.T3 := NUM;
    RETURN L_DATA;
END BUILDARECORD;
|
CREATE OR REPLACE FUNCTION BUILDTBL4(NUM IN INTEGER) RETURN SOMEPACKAGE_TBL4 AS
    L_DATA SOMEPACKAGE_TBL4 := SOMEPACKAGE_TBL4();
    BEGIN
	FOR I IN 1 .. NUM LOOP
	 L_DATA.EXTEND;
	 L_DATA(I) := BUILDTBL2(I);
	END LOOP;
    RETURN L_DATA;
END BUILDTBL4;
|
CREATE OR REPLACE FUNCTION BUILDCRECORD(NUM IN INTEGER) RETURN SOMEPACKAGE_CRECORD AS
    L_DATA SOMEPACKAGE_CRECORD := SOMEPACKAGE_CRECORD(NULL, NULL);
    BEGIN
     L_DATA.C1 := BUILDARECORD(NUM);
     L_DATA.C2 := BUILDTBL2(NUM);
    RETURN L_DATA;
END BUILDCRECORD;
|
CREATE OR REPLACE TYPE EMP_INFO AS OBJECT (
 ID       NUMBER(5),
 NAME     VARCHAR2(50)
)|
CREATE OR REPLACE TYPE EMP_INFO_ARRAY AS VARRAY(3) OF EMP_INFO|
CREATE OR REPLACE PACKAGE ANOTHER_ADVANCED_DEMO
AS
  FUNCTION BUILDEMPARRAY(NUM IN INTEGER) RETURN EMP_INFO_ARRAY;
END;
|
CREATE OR REPLACE PACKAGE BODY ANOTHER_ADVANCED_DEMO AS
  FUNCTION BUILDEMPARRAY(NUM IN INTEGER) RETURN EMP_INFO_ARRAY AS
    L_DATA EMP_INFO_ARRAY := EMP_INFO_ARRAY();
  BEGIN
      FOR I IN 1 .. NUM LOOP
         L_DATA.EXTEND;
         L_DATA(I) := EMP_INFO(I, 'entry ' || i);
      END LOOP;
     RETURN L_DATA;
  END BUILDEMPARRAY;
END;
|
CREATE OR REPLACE TYPE REGION AS OBJECT (
 REG_ID       NUMBER(5),
 REG_NAME     VARCHAR2(50)
)|
CREATE OR REPLACE TYPE EMP_ADDRESS AS OBJECT (
 STREET       VARCHAR2(100),
 SUBURB       VARCHAR2(50),
 ADDR_REGION  REGION,
 POSTCODE     INTEGER
)|
CREATE OR REPLACE TYPE EMP_OBJECT AS OBJECT (
 EMPLOYEE_ID   NUMBER(8),
 ADDRESS       EMP_ADDRESS,
 EMPLOYEE_NAME VARCHAR2(80),
 DATE_OF_HIRE  DATE
)|
CREATE OR REPLACE PACKAGE ADVANCED_OBJECT_DEMO AS
  FUNCTION ECHOREGION(AREGION IN REGION) RETURN REGION;
  FUNCTION ECHOEMPADDRESS(ANEMPADDRESS IN EMP_ADDRESS) RETURN EMP_ADDRESS;
  FUNCTION ECHOEMPOBJECT(ANEMPOBJECT IN EMP_OBJECT) RETURN EMP_OBJECT;
END;
|
CREATE OR REPLACE PACKAGE BODY ADVANCED_OBJECT_DEMO AS
  FUNCTION ECHOREGION(AREGION IN REGION) RETURN REGION AS
  BEGIN
     RETURN AREGION;
  END ECHOREGION;
  FUNCTION ECHOEMPADDRESS(ANEMPADDRESS IN EMP_ADDRESS) RETURN EMP_ADDRESS AS
  BEGIN
    RETURN ANEMPADDRESS;
  END ECHOEMPADDRESS;
  FUNCTION ECHOEMPOBJECT(ANEMPOBJECT IN EMP_OBJECT) RETURN EMP_OBJECT AS
  BEGIN
    RETURN ANEMPOBJECT;
  END ECHOEMPOBJECT;
END;
|
CREATE OR REPLACE PACKAGE TEST_TYPES AS
   FUNCTION ECHO_INTEGER (PINTEGER IN INTEGER) RETURN INTEGER;
   FUNCTION ECHO_SMALLINT(PSMALLINT IN SMALLINT) RETURN SMALLINT;
   FUNCTION ECHO_NUMERIC (PNUMERIC IN NUMERIC) RETURN NUMERIC;
   FUNCTION ECHO_DEC (PDEC IN DEC) RETURN DEC;
   FUNCTION ECHO_DECIMAL (PDECIMAL IN DECIMAL) RETURN DECIMAL;
   FUNCTION ECHO_NUMBER (PNUMBER IN NUMBER) RETURN NUMBER;
   FUNCTION ECHO_VARCHAR(PVARCHAR IN VARCHAR) RETURN VARCHAR;
   FUNCTION ECHO_VARCHAR2 (PINPUTVARCHAR IN VARCHAR2) RETURN VARCHAR2;
   FUNCTION ECHO_CHAR (PINPUTCHAR IN CHAR) RETURN CHAR;
   FUNCTION ECHO_REAL (PREAL IN REAL) RETURN REAL;
   FUNCTION ECHO_FLOAT (PINPUTFLOAT IN FLOAT) RETURN FLOAT;
   FUNCTION ECHO_DOUBLE (PDOUBLE IN DOUBLE PRECISION) RETURN DOUBLE PRECISION;
   FUNCTION ECHO_DATE (PINPUTDATE IN DATE) RETURN DATE;
   FUNCTION ECHO_TIMESTAMP (PINPUTTS IN TIMESTAMP) RETURN TIMESTAMP;
   FUNCTION ECHO_CLOB (PINPUTCLOB IN CLOB) RETURN CLOB;
   FUNCTION ECHO_BLOB (PINPUTBLOB IN BLOB) RETURN BLOB;
   FUNCTION ECHO_LONG (PLONG IN LONG) RETURN LONG;
   FUNCTION ECHO_LONG_RAW (PLONGRAW IN LONG RAW) RETURN LONG RAW;
   FUNCTION ECHO_RAW(PRAW IN RAW) RETURN RAW;
END;
|
CREATE OR REPLACE PACKAGE BODY TEST_TYPES AS
   FUNCTION ECHO_INTEGER (PINTEGER IN INTEGER) RETURN INTEGER IS
   BEGIN
      RETURN PINTEGER;
   END ECHO_INTEGER;
   FUNCTION ECHO_SMALLINT(PSMALLINT IN SMALLINT) RETURN SMALLINT IS
   BEGIN
      RETURN PSMALLINT;
   END ECHO_SMALLINT;
   FUNCTION ECHO_NUMERIC (PNUMERIC IN NUMERIC) RETURN NUMERIC IS
   BEGIN
      RETURN PNUMERIC;
   END ECHO_NUMERIC;
   FUNCTION ECHO_DEC (PDEC IN DEC) RETURN DEC IS
   BEGIN
      RETURN PDEC;
   END ECHO_DEC;
   FUNCTION ECHO_DECIMAL (PDECIMAL IN DECIMAL) RETURN DECIMAL IS
   BEGIN
      RETURN PDECIMAL;
   END ECHO_DECIMAL;
   FUNCTION ECHO_NUMBER (PNUMBER IN NUMBER) RETURN NUMBER IS
   BEGIN
      RETURN PNUMBER;
   END ECHO_NUMBER;
   FUNCTION ECHO_VARCHAR(PVARCHAR IN VARCHAR) RETURN VARCHAR IS
   BEGIN
      RETURN PVARCHAR;
   END ECHO_VARCHAR;
   FUNCTION ECHO_VARCHAR2 (PINPUTVARCHAR IN VARCHAR2) RETURN VARCHAR2 IS
   BEGIN
      RETURN PINPUTVARCHAR;
   END ECHO_VARCHAR2;
   FUNCTION ECHO_CHAR (PINPUTCHAR IN CHAR) RETURN CHAR IS
   BEGIN
      RETURN PINPUTCHAR;
   END ECHO_CHAR;
   FUNCTION ECHO_REAL (PREAL IN REAL) RETURN REAL IS
   BEGIN
      RETURN PREAL;
   END ECHO_REAL;
   FUNCTION ECHO_FLOAT (PINPUTFLOAT IN FLOAT) RETURN FLOAT IS
   BEGIN
      RETURN PINPUTFLOAT;
   END ECHO_FLOAT;
   FUNCTION ECHO_DOUBLE (PDOUBLE IN DOUBLE PRECISION) RETURN DOUBLE PRECISION IS
   BEGIN
      RETURN PDOUBLE;
   END ECHO_DOUBLE;
   FUNCTION ECHO_DATE (PINPUTDATE IN DATE) RETURN DATE IS
   BEGIN
      RETURN PINPUTDATE;
   END ECHO_DATE;
   FUNCTION ECHO_TIMESTAMP (PINPUTTS IN TIMESTAMP) RETURN TIMESTAMP IS
   BEGIN
      RETURN PINPUTTS;
   END ECHO_TIMESTAMP;
   FUNCTION ECHO_CLOB (PINPUTCLOB IN CLOB) RETURN CLOB IS
   BEGIN
      RETURN PINPUTCLOB;
   END ECHO_CLOB;
   FUNCTION ECHO_BLOB (PINPUTBLOB IN BLOB) RETURN BLOB IS
   BEGIN
      RETURN PINPUTBLOB;
   END ECHO_BLOB;
   FUNCTION ECHO_LONG (PLONG IN LONG) RETURN LONG IS
   BEGIN
      RETURN PLONG;
   END ECHO_LONG;
   FUNCTION ECHO_LONG_RAW (PLONGRAW IN LONG RAW) RETURN LONG RAW IS
   BEGIN
      RETURN PLONGRAW;
   END ECHO_LONG_RAW;
   FUNCTION ECHO_RAW(PRAW IN RAW) RETURN RAW IS
   BEGIN
      RETURN PRAW;
   END ECHO_RAW;
END;
|
CREATE TABLE LTBL ( 
  EMPNO NUMBER(4) NOT NULL, 
  FNAME VARCHAR2(40), 
  LNAME VARCHAR2(40),  
  PRIMARY KEY (EMPNO) 
)|
CREATE TYPE LTBL_PKG_LTBL_REC AS OBJECT (
      EMPNO NUMBER(4),
      FNAME VARCHAR2(40),
      LNAME VARCHAR2(40)
)|
CREATE TYPE LTBL_PKG_LTBL_TAB AS TABLE OF LTBL_PKG_LTBL_REC|
CREATE PACKAGE LTBL_PKG AS
  TYPE LTBL_REC IS RECORD(
    EMPNO LTBL.EMPNO%TYPE,
    FNAME LTBL.FNAME%TYPE,
    LNAME LTBL.LNAME%TYPE
  );
  TYPE LTBL_TAB IS TABLE OF LTBL_REC INDEX BY BINARY_INTEGER;
  PROCEDURE LTBL_QUERY(BLOCK_DATA IN OUT LTBL_TAB, P_EMPNO IN NUMBER);
END;
|
CREATE PACKAGE BODY LTBL_PKG AS
  PROCEDURE LTBL_QUERY(BLOCK_DATA IN OUT LTBL_TAB, P_EMPNO IN NUMBER) IS
  BEGIN
    BLOCK_DATA(2).EMPNO := 789;
    BLOCK_DATA(2).FNAME := 'John';
    BLOCK_DATA(2).LNAME := 'Blair';
  END;
END;
|
CREATE OR REPLACE TYPE TESMAN_TYPE1 AS OBJECT (
 ACCT          NUMBER,
 COUNTRY       VARCHAR2(30),
 ADDR_DIVISION VARCHAR2(30),
 STATE         VARCHAR2(30)
)
|
CREATE OR REPLACE TYPE TESMAN_TYPE2 AS OBJECT (
 PNR     NUMBER,
 COMPANY VARCHAR2(30),
 SE      VARCHAR2(30),
 SCRIP   VARCHAR2(30),
 TT      TESMAN_TYPE1
)
|
CREATE OR REPLACE TYPE TESMAN_TYPE3 AS VARRAY(2) OF TESMAN_TYPE2
|
CREATE TABLE TESMAN_TABLE1 (
  IDE NUMBER,
  IDTT TESMAN_TYPE1
)
|
CREATE TABLE TESMAN_TABLE2 (
  SRNO NUMBER,
  DETAIL TESMAN_TYPE2
)
|
CREATE TABLE TESMAN_TABLE3 (
  ID INTEGER,
  TT3 TESMAN_TYPE3
)
|
CREATE OR REPLACE PACKAGE TESMANPACK AS
  FUNCTION TESMANFUNC17(PARAM1 IN INTEGER) RETURN TESMAN_TABLE2%ROWTYPE;
  PROCEDURE TESMANPROC17(PARAM1 IN INTEGER, REC OUT TESMAN_TABLE2%ROWTYPE);
  PROCEDURE TESMANPROC17b(OLDREC IN TESMAN_TABLE3%ROWTYPE, NEWREC OUT TESMAN_TABLE3%ROWTYPE);
END TESMANPACK;
|
CREATE OR REPLACE PACKAGE BODY TESMANPACK AS

  FUNCTION TESMANFUNC17(PARAM1 IN INTEGER) RETURN TESMAN_TABLE2%ROWTYPE AS
    L_DATA1 TESMAN_TABLE2%ROWTYPE;
    CURSOR C_EMP(PARAMTEMP IN INTEGER) IS SELECT * FROM TESMAN_TABLE2 TE WHERE TE.SRNO=PARAMTEMP;
  BEGIN
      OPEN C_EMP(PARAM1);
      LOOP
        FETCH C_EMP INTO L_DATA1;
        EXIT WHEN C_EMP%NOTFOUND;
      END LOOP;
      RETURN L_DATA1;
  END;

  PROCEDURE TESMANPROC17( PARAM1 IN INTEGER, REC OUT TESMAN_TABLE2%ROWTYPE) AS
  BEGIN
    REC := TESMANFUNC17(PARAM1);
  END;

  PROCEDURE TESMANPROC17b(OLDREC IN TESMAN_TABLE3%ROWTYPE, NEWREC OUT TESMAN_TABLE3%ROWTYPE) AS
  BEGIN
    NEWREC := OLDREC;
  END;

END TESMANPACK;
|