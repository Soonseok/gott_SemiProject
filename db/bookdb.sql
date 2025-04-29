--------------------------------------------------------
--  파일이 생성됨 - 화요일-4월-29-2025   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOOKDB
--------------------------------------------------------

  CREATE TABLE "BLUE"."BOOKDB" 
   (	"BOOK_ID" VARCHAR2(10 BYTE), 
	"AUTHOR" VARCHAR2(100 BYTE), 
	"TITLE" VARCHAR2(200 BYTE), 
	"PRICE" NUMBER, 
	"COVER_IMAGE" VARCHAR2(200 BYTE), 
	"BOOK_ABSTRACT" CLOB
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("BOOK_ABSTRACT") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW 4000 CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES 
  STORAGE(INITIAL 262144 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
REM INSERTING into BLUE.BOOKDB
SET DEFINE OFF;
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_12','Kittel','Introduction to Solid State Physics',60000,'kittel_solid_state_physics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_17','Griffiths','Introduction to Electrodynamics',57000,'griffiths_electrodynamics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_20','Howard Georgi','Lie Algebras in Particle Physics',62000,'georgi_lie_algebras.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_30','Serway','Modern Physics',54000,'serway_modern_physics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_38','Feynman','Feynman Lectures on Physics: The New Millennium Edition',30000,'feynman_vol.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_41','Landau and Lifshitz','Course of Theoretical Physics Vol.3: Quantum Mechanics',48000,'landau_vol3.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_42','Lifshitz, Berestetsky, Pitaevskii','Course of Theoretical Physics Vol.4: Quantum Electrodynamics',48000,'landau_vol4.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_43','Landau and Lifshitz','Course of Theoretical Physics Vol.5: Statistical Physics Part 1',48000,'landau_vol5.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_45','Landau and Lifshitz','Course of Theoretical Physics Vol.7: Theory of Elasticity',48000,'landau_vol7.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_0','Einstein','The Meaning of Relativity',50000,'einstein_the_meaning_of_relativity.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_1','Arfken','Mathematical Methods for Physicists',62000,'arfken_mathematical_methods.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_2','Schutz','A First Course in General Relativity',53000,'schutz_general_relativity.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_16','Gasiorowicz','Quantum Physics',58000,'gasiorowicz_quantum_physics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_28','Stephen Thornton','Classical Dynamics of Particles and Systems',60000,'thornton_classical_dynamics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_29','Daniel Schroeder','Thermal Physics',55000,'schroeder_thermal_physics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_4','Brian Greene','The Fabric of the Cosmos',47000,'greene_the_fabric_of_the_cosmos.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_5','Brian Greene','The Hidden Reality',49000,'greene_the_hidden_reality.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_1','Lay','Linear Algebra and Its Applications',49000,'lay_linearAlgebra.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_7','Apostol','Calculus Vol. 2',62000,'apostol_calculus2.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_13','Gallian','Contemporary Abstract Algebra',53000,'gallian_abstractAlgebra.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_2','Clayden','Organic Chemistry',72000,'clayden_organicChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_5','Pauling','General Chemistry',60000,'pauling_generalChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_10','Pavia','Introduction to Spectroscopy',59000,'pavia_spectroscopy.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_2','David E. Sadava','Life: The Science of Biology',72000,'purves_lifeScienceBiology.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_9','Sadava','Life: The Science of Biology',72000,'sadava_lifeScienceBiology.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_12','Anthony Griffiths','Introduction to Genetic Analysis',67000,'griffiths_geneticAnalysis.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_3','Brian Greene','The Elegant Universe',45000,'greene_the_elegant_universe.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_0','Stewart','Calculus: Early Transcendentals',55000,'stewart_calculus.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_2','Rudin','Principles of Mathematical Analysis',60000,'rudin_analysis.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_3','Spivak','Calculus',58000,'spivak_calculus.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_4','Axler','Linear Algebra Done Right',50000,'axler_linearAlgebra.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_5','Hungerford','Abstract Algebra',62000,'hungerford_abstractAlgebra.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_6','Apostol','Calculus Vol. 1',59000,'apostol_calculus1.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_8','Dummit','Abstract Algebra',64000,'dummit_abstractAlgebra.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_9','Kreyszig','Advanced Engineering Mathematics',65000,'kreyszig_engineeringMath.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_10','Goldstein','Classical Mechanics',64000,'goldstein_classical_mechanics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_15','Chang','Chemistry',63000,'chang_chemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_6','Housecroft','Inorganic Chemistry',68000,'housecroft_inorganicChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_7','Miessler','Inorganic Chemistry',69000,'miessler_inorganicChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_11','Hassani','Mathematical Physics',58000,'hassani_mathematical_physics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_10','Rosen','Discrete Mathematics and Its Applications',52000,'rosen_discreteMath.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_11','Folland','Real Analysis: Modern Techniques and Their Applications',68000,'folland_realAnalysis.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_12','Munkres','Topology',60000,'munkres_topology.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_14','Walter Rudin','Measure Theory',70000,'baby_measureTheory.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_0','Atkins','Physical Chemistry',67000,'atkins_physicalChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_1','McQuarrie','Quantum Chemistry',62000,'mcquarrie_quantumChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_12','McMurry','Organic Chemistry',69000,'mcmurry_organicChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('m_15','Hoffman','Linear Algebra',54000,'hoffman_linearAlgebra.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_3','Brown','Chemistry: The Central Science',65000,'brown_centralScience.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_4','Zumdahl','Chemistry',64000,'zumdahl_chemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_11','Huheey','Inorganic Chemistry: Principles of Structure and Reactivity',68000,'huheey_inorganicChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_13','Petrucci','General Chemistry: Principles and Modern Applications',64000,'petrucci_generalChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_14','Cotton','Chemical Applications of Group Theory',66000,'cotton_groupTheory.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_6','Brian Greene','Until the End of Time',55000,'greene_until_the_end_of_time.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_7','Jackson','Classical Electrodynamics',68000,'jackson_classical_electrodynamics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_8','Sakurai','Modern Quantum Mechanics',66000,'sakurai_modern_quantum_mechanics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_9','Peskin','An Introduction to Quantum Field Theory',72000,'peskin_quantum_field_theory.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_3','Freeman','Biological Science',67000,'freeman_biologicalScience.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_4','Alberts','Molecular Biology of the Cell',74000,'alberts_molecularBiologyCell.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_5','Berg','Biochemistry',71000,'berg_biochemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_6','David L. Nelson','Principles of Biochemistry',70000,'lehninger_biochemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_21','Aitchison','Gauge Theories in Particle Physics',69000,'aitchison_gauge_theories.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_22','Hartle','Gravity: An Introduction to Einstein''s General Relativity',63000,'hartle_gravity.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_23','Kenneth Krane','Introductory Nuclear Physics',61000,'krane_nuclear_physics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_10','Lodish','Molecular Cell Biology',75000,'lodish_molecularCellBiology.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_11','Pierce','Genetics: A Conceptual Approach',69000,'pierce_genetics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_13','Snustad','Principles of Genetics',68000,'snustad_principlesGenetics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_14','Ridley','Evolution',65000,'ridley_evolution.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_15','Futuyma','Evolution',66000,'futuyma_evolution.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_7','Voet','Biochemistry',73000,'voet_biochemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_8','Karp','Cell and Molecular Biology',71000,'karp_cellMolecularBiology.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_35','Feynman','The Feynman Lectures on Physics Vol.1',45000,'feynman_vol.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_36','Feynman','The Feynman Lectures on Physics Vol.2',45000,'feynman_vol.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_37','Feynman','The Feynman Lectures on Physics Vol.3',45000,'feynman_vol.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_39','Landau and Lifshitz','Course of Theoretical Physics Vol.1: Mechanics',48000,'landau_vol1.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_40','Landau and Lifshitz','Course of Theoretical Physics Vol.2: The Classical Theory of Fields',48000,'landau_vol2.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_44','Landau and Lifshitz','Course of Theoretical Physics Vol.6: Fluid Mechanics',48000,'landau_vol6.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_46','Lifshitz, Pitaevskii','Course of Theoretical Physics Vol.8: Electrodynamics of Continuous Media',48000,'landau_vol8.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_47','Lifshitz, Pitaevskii','Course of Theoretical Physics Vol.9: Statistical Physics Part 2',48000,'landau_vol9.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_48','Lifshitz, Pitaevskii','Course of Theoretical Physics Vol.10: Physical Kinetics',48000,'landau_vol10.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_13','Cliff Burgess','The Standard Model',69000,'cliff_standard_model.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_14','Daniel Fleisch','A Student''s Guide to Waves',41000,'fleisch_waves.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_15','Francis Chen','Introduction to Plasma Physics and Controlled Fusion',66000,'chen_plasma_physics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_18','Hecht','Optics',55000,'hecht_optics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_19','Wolf','Optical Coherence and Quantum Optics',76000,'wolf_optics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_8','Shriver','Inorganic Chemistry',67000,'shriver_inorganicChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('c_9','Morrison','Organic Chemistry',71000,'morrison_organicChemistry.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_0','Campbell','Biology',69000,'campbell_biology.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('b_1','Raven','Biology',68000,'raven_biology.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_31','Serway','Physics for Scientists and Engineers',69000,'serway_general_physics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_32','Stephen Martin','A Supersymmetry Primer',63000,'martin_susy.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_33','Barry Simon','Solid State Basics',57000,'simon_solid_state.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_34','Ben Streetman','Solid State Electronic Devices',59000,'streetman_solid_state.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_24','Ryder','Introduction to General Relativity',56000,'ryder_general_relativity.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_25','Boas','Mathematical Methods in the Physical Sciences',52000,'boas_math_methods.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_26','David L. Nelson','Biological Physics',59000,'nelson_biological_physics.jpg');
Insert into BLUE.BOOKDB (BOOK_ID,AUTHOR,TITLE,PRICE,COVER_IMAGE) values ('p_27','Pierre Ramond','Group Theory: A Physicist''s Survey',61000,'ramond_group_theory.jpg');
--------------------------------------------------------
--  DDL for Index SYS_C008330
--------------------------------------------------------

  CREATE UNIQUE INDEX "BLUE"."SYS_C008330" ON "BLUE"."BOOKDB" ("BOOK_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BOOKDB
--------------------------------------------------------

  ALTER TABLE "BLUE"."BOOKDB" MODIFY ("AUTHOR" NOT NULL ENABLE);
  ALTER TABLE "BLUE"."BOOKDB" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "BLUE"."BOOKDB" ADD PRIMARY KEY ("BOOK_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
