--------------------------------------------------------
--  파일이 생성됨 - 화요일-4월-29-2025   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AUTHORDB
--------------------------------------------------------

  CREATE TABLE "BLUE"."AUTHORDB" 
   (	"AUTHOR" VARCHAR2(100 BYTE), 
	"AUTHOR_ABSTRACT" CLOB
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("AUTHOR_ABSTRACT") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW 4000 CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES 
  STORAGE(INITIAL 262144 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
REM INSERTING into BLUE.AUTHORDB
SET DEFINE OFF;
Insert into BLUE.AUTHORDB (AUTHOR) values ('Aitchison');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Alberts');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Anthony Griffiths');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Apostol');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Arfken');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Atkins');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Axler');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Barry Simon');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Ben Streetman');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Berg');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Boas');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Brian Greene');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Brown');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Campbell');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Chang');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Clayden');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Cliff Burgess');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Cotton');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Daniel Fleisch');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Daniel Schroeder');
Insert into BLUE.AUTHORDB (AUTHOR) values ('David E. Sadava');
Insert into BLUE.AUTHORDB (AUTHOR) values ('David L. Nelson');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Dummit');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Einstein');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Feynman');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Folland');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Francis Chen');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Freeman');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Futuyma');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Gallian');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Gasiorowicz');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Goldstein');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Griffiths');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Hartle');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Hassani');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Hecht');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Hoffman');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Housecroft');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Howard Georgi');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Huheey');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Hungerford');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Jackson');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Karp');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Kenneth Krane');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Kittel');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Kreyszig');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Landau and Lifshitz');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Lay');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Lifshitz, Berestetsky, Pitaevskii');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Lifshitz, Pitaevskii');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Lodish');
Insert into BLUE.AUTHORDB (AUTHOR) values ('McMurry');
Insert into BLUE.AUTHORDB (AUTHOR) values ('McQuarrie');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Miessler');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Morrison');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Munkres');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Pauling');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Pavia');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Peskin');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Petrucci');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Pierce');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Pierre Ramond');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Raven');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Ridley');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Rosen');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Rudin');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Ryder');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Sadava');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Sakurai');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Schutz');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Serway');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Shriver');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Snustad');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Spivak');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Stephen Martin');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Stephen Thornton');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Stewart');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Voet');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Walter Rudin');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Wolf');
Insert into BLUE.AUTHORDB (AUTHOR) values ('Zumdahl');
--------------------------------------------------------
--  DDL for Index SYS_C008331
--------------------------------------------------------

  CREATE UNIQUE INDEX "BLUE"."SYS_C008331" ON "BLUE"."AUTHORDB" ("AUTHOR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table AUTHORDB
--------------------------------------------------------

  ALTER TABLE "BLUE"."AUTHORDB" ADD PRIMARY KEY ("AUTHOR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
