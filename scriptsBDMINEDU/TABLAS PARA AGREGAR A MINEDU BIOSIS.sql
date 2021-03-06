/****** Object:  Schema [institucional]    Script Date: 02/25/2016 01:01:28 ******/
CREATE SCHEMA institucional AUTHORIZATION dbo
GO
/****** Object:  Schema [biostar]    Script Date: 02/25/2016 01:01:28 ******/
CREATE SCHEMA biostar AUTHORIZATION dbo
GO
/****** Object:  Table Jornada    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE Jornada(
	codigo varchar(45) PRIMARY KEY NOT NULL,
	nombre varchar(255) NOT NULL,
	tipo char(1) NOT NULL,
	descripcion varchar(255) NULL,
	activo bit NULL,
);
/****** Object:  Table Horario    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE Horario(
	codigo varchar(45) PRIMARY KEY NOT NULL,
	documento varchar(255) NOT NULL,
	nombre varchar(255) NOT NULL,
	tipo char(1) NULL,
);
/****** Object:  Table grupo_horario    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE grupo_horario(
	codigo varchar(45) PRIMARY KEY NOT NULL,
	nombre varchar(255) NOT NULL,
);
/****** Object:  Table institucional.area    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE institucional.area(
	area_id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	area_nombre varchar(255) NOT NULL,
	area_superior_id bigint NULL,
	area_es_sede bit NOT NULL,
	area_descripcion varchar(255) NULL,
	area_codigo varchar(45) NULL,
);
/****** Object:  Table Bitacora    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE Bitacora(
	id bigint PRIMARY KEY NOT NULL,
	accion char(1) NULL,
	campo varchar(255) NULL,
	fechaHora datetime NULL,
	ip varchar(255) NULL,
	tabla varchar(255) NULL,
	usuario varchar(255) NULL,
	valorAnterior varchar(255) NULL,
	valorPosterior varchar(255) NULL,
);
/****** Object:  Table tipo_permiso    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE tipo_permiso(
	codigo varchar(255) PRIMARY KEY NOT NULL,
	clase char(1) NOT NULL,
	diasMaximo int NULL,
	nombre varchar(255) NOT NULL,
	tipo_descuento char(1) NOT NULL,
);
/****** Object:  Table rol_acceso    Script Date: 02/24/2016 20:26:54 ******/
-- CREATE TABLE rol_acceso(
-- 	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
-- 	acceso_id bigint NULL,
-- 	rol_codigo varchar(255) NULL,
-- );
/****** Object:  Table turno    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE turno(
	id bigint IDENTITY(1,1) PRIMARY KEY NOT NULL,
	domingo bit NULL,
	fecha_inicio datetime NULL,
	jueves bit NULL,
	lunes bit NULL,
	martes bit NULL,
	miercoles bit NULL,
	sabado bit NULL,
	tipo char(1) NULL,
	viernes bit NULL,
	horario_codigo varchar(45) NOT NULL,
	jornada_codigo varchar(45) NOT NULL,
	fecha_fin datetime NULL,
);
/****** Object:  Table Feriado    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE Feriado(
	fecha_inicio datetime PRIMARY KEY NOT NULL,
	fecha_fin datetime NOT NULL,
	nombre varchar(255) NOT NULL,
	periodo_anio int NOT NULL,
);
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A2A600000000 AS DateTime), CAST(0x0000A2A600000000 AS DateTime),'AÑO NUEVO', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A30200000000 AS DateTime), CAST(0x0000A30500000000 AS DateTime),'SEMANA SANTA', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A31E00000000 AS DateTime), CAST(0x0000A31E00000000 AS DateTime),'DIA DEL TRABAJO', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A35400000000 AS DateTime), CAST(0x0000A35400000000 AS DateTime),'INTI RAYMI', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A35900000000 AS DateTime), CAST(0x0000A35900000000 AS DateTime),'FESTIVIDAD DE SAN PEDRO Y SAN PABLO', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A37600000000 AS DateTime), CAST(0x0000A37700000000 AS DateTime),'FIESTA DE LA INDEPENDECIA NACIONAL', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A39700000000 AS DateTime), CAST(0x0000A39700000000 AS DateTime),'FESTIVIDAD DE SANTA ROSA DE LIMA', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A3BE00000000 AS DateTime), CAST(0x0000A3BE00000000 AS DateTime),'CELEBRACION DE LA BATALLA DE ANGAMOS', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A3D600000000 AS DateTime), CAST(0x0000A3D600000000 AS DateTime),'DIA DE TODOS LOS SANTOS', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A3FB00000000 AS DateTime), CAST(0x0000A3FB00000000 AS DateTime),'DIA DE LA INMACULADA CONCEPCION', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A40C00000000 AS DateTime), CAST(0x0000A40C00000000 AS DateTime),'NAVIDAD', 2014)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A41300000000 AS DateTime), CAST(0x0000A41300000000 AS DateTime),'AÑO NUEVO', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A46E00000000 AS DateTime), CAST(0x0000A47100000000 AS DateTime),'SEMANA SANTA', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A48B00000000 AS DateTime), CAST(0x0000A48B00000000 AS DateTime),'DIA DEL TRABAJO', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A4C100000000 AS DateTime), CAST(0x0000A4C100000000 AS DateTime),'INTI RAYMI', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A4C600000000 AS DateTime), CAST(0x0000A4C600000000 AS DateTime),'FESTIVIDAD DE SAN PEDRO Y SAN PABLO', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A4E300000000 AS DateTime), CAST(0x0000A4E400000000 AS DateTime),'FIESTA DE LA INDEPENDECIA NACIONAL', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A50400000000 AS DateTime), CAST(0x0000A50400000000 AS DateTime),'FESTIVIDAD DE SANTA ROSA DE LIMA', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A52B00000000 AS DateTime), CAST(0x0000A52B00000000 AS DateTime),'CELEBRACION DE LA BATALLA DE ANGAMOS', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A54300000000 AS DateTime), CAST(0x0000A54300000000 AS DateTime),'DIA DE TODOS LOS SANTOS', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A56800000000 AS DateTime), CAST(0x0000A56800000000 AS DateTime),'DIA DE LA INMACULADA CONCEPCION', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A57900000000 AS DateTime), CAST(0x0000A57900000000 AS DateTime),'NAVIDAD', 2015)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A58000000000 AS DateTime), CAST(0x0000A58000000000 AS DateTime),'AÑO NUEVO', 2016)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A5DC00000000 AS DateTime), CAST(0x0000A5DF00000000 AS DateTime),'SEMANA SANTA', 2016)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A5F900000000 AS DateTime), CAST(0x0000A5F900000000 AS DateTime),'DIA DEL TRABAJO', 2016)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A62F00000000 AS DateTime), CAST(0x0000A62F00000000 AS DateTime),'INTI RAYMI', 2016)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A63400000000 AS DateTime), CAST(0x0000A63400000000 AS DateTime),'FESTIVIDAD DE SAN PEDRO Y SAN PABLO', 2016)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A65100000000 AS DateTime), CAST(0x0000A65200000000 AS DateTime),'FIESTA DE LA INDEPENDECIA NACIONAL', 2016)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A67200000000 AS DateTime), CAST(0x0000A67200000000 AS DateTime),'FESTIVIDAD DE SANTA ROSA DE LIMA', 2016)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A69900000000 AS DateTime), CAST(0x0000A69900000000 AS DateTime),'CELEBRACION DE LA BATALLA DE ANGAMOS', 2016)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A6B100000000 AS DateTime), CAST(0x0000A6B100000000 AS DateTime),'DIA DE TODOS LOS SANTOS', 2016)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A6D600000000 AS DateTime), CAST(0x0000A6D600000000 AS DateTime),'DIA DE LA INMACULADA CONCEPCION', 2016)
INSERT Feriado (fecha_inicio, fecha_fin, nombre, periodo_anio) VALUES (CAST(0x0000A6E700000000 AS DateTime), CAST(0x0000A6E700000000 AS DateTime),'NAVIDAD', 2016)
/****** Object:  Table detalle_jornada    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE detalle_jornada(
	dtjorn_id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	dtjorn_entrada datetime NOT NULL,
	dtjorn_entrada_desde datetime NOT NULL,
	dtjorn_entrada_hasta datetime NOT NULL,
	dtjorn_entrada_tolerancia datetime NOT NULL,
	dtjorn_salida datetime NOT NULL,
	dtjorn_salida_desde datetime NOT NULL,
	dtjorn_salida_hasta datetime NOT NULL,
	dtjorn_salida_dia_siguiente bit NOT NULL,
	jorn_codigo varchar(45) NOT NULL,
);
/****** Object:  Table Permiso    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE Permiso(
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	a_compensar bit NOT NULL,
	cubre_entrada bit NOT NULL,
	cubre_salida bit NOT NULL,
	diferencia_minutos numeric(19, 2) NOT NULL,
	documento varchar(255) NOT NULL,
	fecha_fin datetime NOT NULL,
	fecha_inicio datetime NOT NULL,
	hora_fin datetime NULL,
	hora_inicio datetime NULL,
	motivo varchar(255) NULL,
	opcion char(1) NOT NULL,
	por_fecha bit NOT NULL,
	tipo_permiso_codigo varchar(255) NOT NULL,
);

--SE PUSO COMO "NOT NULL" LA OPCION
/****** Object:  Table autorizacion    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE autorizacion(
	aut_id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	aut_documento_referencia varchar(255) NULL,
	aut_tipo char(1) NOT NULL,
	aut_motivo varchar(255) NULL,
	aut_fecha datetime NOT NULL,
	pers_nro_documento varchar(255) NOT NULL,
	dtjorn_id bigint NOT NULL,
);
/****** Object:  Table asignacion_permiso    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE asignacion_permiso(
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	empleado_nro_documento varchar(255) NULL,
	permiso_id bigint NOT NULL,
);
/****** Object:  Table asignacion_horario    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE asignacion_horario(
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	por_grupo bit NOT NULL,
	empleado_nro_documento varchar(255) NULL,
	grupo_horario_codigo varchar(45) NULL,
	horario_codigo varchar(45) NOT NULL,
	fecha_inicio datetime NULL,
	fecha_fin datetime NULL,
);
/****** Object:  Table detalle_grupo_horario    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE detalle_grupo_horario(
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	empleado_nro_documento varchar(255) NULL,
	grupo_horario_codigo varchar(45) NOT NULL,
);
/****** Object:  Table compra_vacacion    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE compra_vacacion(
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	dias_comprados int NULL,
	empleado_nro_documento varchar(255) NULL,
	periodo_anio int NULL,
);
/****** Object:  Table cambio_turno    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE cambio_turno(
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	empleado1_nro_documento varchar(255) NULL,
	empleado2_nro_documento varchar(255) NULL,
	turno1_id bigint NULL,
	turno2_id bigint NULL,
);
/****** Object:  Table saldo_vacacional    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE saldo_vacacional(
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	dias_restantes int NULL,
	domingo int NULL,
	fecha_desde datetime NULL,
	fecha_hasta datetime NULL,
	lunes_viernes int NULL,
	sabado int NULL,
	empleado_nro_documento varchar(255) NULL,
	periodo_anio int NOT NULL,
);
/****** Object:  Table detalle_registro_asistencia    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE detalle_registro_asistencia(
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	hora_fin datetime NULL,
	hora_inicio datetime NULL,
	minutos_extra numeric(19, 2) NULL,
	minutos_tardanza numeric(19, 2) NULL,
	orden int NULL,
	resultado char(1) NOT NULL,
	tipo_registro char(1) NOT NULL,
	permiso_id bigint NULL,
	registro_asistencia_id bigint NOT NULL,
	dtjorn_id bigint NOT NULL,
);
/****** Object:  Table Vacacion    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE Vacacion(
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	documento varchar(255) NULL,
	documento_reprogramacion varchar(255) NULL,
	fecha_fin datetime NOT NULL,
	fecha_inicio datetime NOT NULL,
	fecha_interrupcion datetime NULL,
	hay_interrupcion bit NOT NULL,
	hay_reprogramacion bit NULL,
	empleado_nro_documento varchar(255) NULL,
	periodo_anio int NOT NULL,
	vacacion_id bigint NULL,
	resolucion varchar(255) NULL,
	sinad varchar(255) NULL,
	observacion varchar(255) NULL,
	reprogramacion_total bit NULL,
);

--Se agrego reprogramacion_total 
/****** Object:  View institucional.v_area    Script Date: 02/24/2016 20:26:56 ******/

/****** Object:  Table registro_asistencia    Script Date: 02/24/2016 20:26:54 ******/
CREATE TABLE registro_asistencia(
	id bigint PRIMARY KEY IDENTITY(1,1) NOT NULL,
	compensacion bit NULL,
	fecha datetime NOT NULL,
	minutos_compensados numeric(19, 2) NULL,
	minutos_extra numeric(19, 2) NULL,
	minutos_tardanza numeric(19, 2) NULL,
	minutos_trabajados numeric(19, 2) NULL,
	tipo_asistencia char(1) NOT NULL,
	empleado_nro_documento varchar(255) NULL,
	feriado_fecha_inicio datetime NULL,
	horario_codigo varchar(45) NULL,
	permiso_id bigint NULL,
	vacacion_id bigint NULL,
	jornada_codigo varchar(45) NULL,
);
/****** Object:  Default DF__asignacio__por_g__2739D489    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE asignacion_horario ADD  DEFAULT ('0') FOR por_grupo
GO
/****** Object:  Default DF__autorizac__aut_t__3A4CA8FD    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE autorizacion ADD  DEFAULT ('H') FOR aut_tipo
GO
/****** Object:  Default DF__detalle_j__dtjor__797309D9    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE detalle_jornada ADD  DEFAULT ('False') FOR dtjorn_salida_dia_siguiente
GO
/****** Object:  Default DF__Horario__documen__245D67DE    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE Horario ADD  DEFAULT ('-') FOR documento
GO
/****** Object:  Default DF__Horario__tipo__25518C17    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE Horario ADD  DEFAULT ('A') FOR tipo
GO
/****** Object:  Default DF__Jornada__tipo__02FC7413    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE Jornada ADD  DEFAULT ('A') FOR tipo
GO
/****** Object:  Default DF__Jornada__activo__04E4BC85    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE Jornada ADD  DEFAULT ((1)) FOR activo
GO
/****** Object:  Default DF__turno__tipo__2645B050    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE turno ADD  DEFAULT ('S') FOR tipo
GO
/****** Object:  Default DF__area__area_es_se__2BFE89A6    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE institucional.area ADD  DEFAULT ('0') FOR area_es_sede
GO
/****** Object:  ForeignKey fk_asignacion_horario__horario    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE asignacion_horario  WITH CHECK ADD  CONSTRAINT fk_asignacion_horario__horario FOREIGN KEY(horario_codigo)
REFERENCES Horario (codigo)
GO
ALTER TABLE asignacion_horario CHECK CONSTRAINT fk_asignacion_horario__horario
GO
/****** Object:  ForeignKey FK_i0ike2swkfxdb6nmfhmxlu12d    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE asignacion_horario  WITH CHECK ADD  CONSTRAINT FK_i0ike2swkfxdb6nmfhmxlu12d FOREIGN KEY(empleado_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
-- ALTER TABLE asignacion_horario CHECK CONSTRAINT FK_i0ike2swkfxdb6nmfhmxlu12d
-- GO
/****** Object:  ForeignKey fk_asignacion_horario__grupo_horario    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE asignacion_horario  WITH CHECK ADD  CONSTRAINT fk_asignacion_horario__grupo_horario FOREIGN KEY(grupo_horario_codigo)
REFERENCES grupo_horario (codigo)
GO
ALTER TABLE asignacion_horario CHECK CONSTRAINT fk_asignacion_horario__grupo_horario
GO
/****** Object:  ForeignKey FK_c7om1mpmqpi3uomtbshuelbw6    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE asignacion_permiso  WITH CHECK ADD  CONSTRAINT FK_c7om1mpmqpi3uomtbshuelbw6 FOREIGN KEY(empleado_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
-- ALTER TABLE asignacion_permiso CHECK CONSTRAINT FK_c7om1mpmqpi3uomtbshuelbw6
-- GO
/****** Object:  ForeignKey fk_asignacion_permiso__permiso    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE asignacion_permiso  WITH CHECK ADD  CONSTRAINT fk_asignacion_permiso__permiso FOREIGN KEY(permiso_id)
REFERENCES Permiso (id)
GO
ALTER TABLE asignacion_permiso CHECK CONSTRAINT fk_asignacion_permiso__permiso
GO
/****** Object:  ForeignKey fk__asistencia__autorizacion__asistencia__detalle_jornada__dtjorn_id    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE autorizacion  WITH CHECK ADD  CONSTRAINT fk__asistencia__autorizacion__asistencia__detalle_jornada__dtjorn_id FOREIGN KEY(dtjorn_id)
REFERENCES detalle_jornada (dtjorn_id)
GO
ALTER TABLE autorizacion CHECK CONSTRAINT fk__asistencia__autorizacion__asistencia__detalle_jornada__dtjorn_id
GO
/****** Object:  ForeignKey fk__asistencia__autorizacion__personal__persona__pers_nro_documento    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE autorizacion  WITH CHECK ADD  CONSTRAINT fk__asistencia__autorizacion__personal__persona__pers_nro_documento FOREIGN KEY(pers_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
-- ALTER TABLE autorizacion CHECK CONSTRAINT fk__asistencia__autorizacion__personal__persona__pers_nro_documento
-- GO
/****** Object:  ForeignKey fk_cambio_turno__turno_1    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE cambio_turno  WITH CHECK ADD  CONSTRAINT fk_cambio_turno__turno_1 FOREIGN KEY(turno1_id)
REFERENCES turno (id)
GO
ALTER TABLE cambio_turno CHECK CONSTRAINT fk_cambio_turno__turno_1
GO
/****** Object:  ForeignKey FK_lajh8xnhf0x5lhedkn2g5r0f6    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE cambio_turno  WITH CHECK ADD  CONSTRAINT FK_lajh8xnhf0x5lhedkn2g5r0f6 FOREIGN KEY(empleado2_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
-- ALTER TABLE cambio_turno CHECK CONSTRAINT FK_lajh8xnhf0x5lhedkn2g5r0f6
-- GO
/****** Object:  ForeignKey FK_o59c42r6l2dgqgux6bkg0hl52    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE cambio_turno  WITH CHECK ADD  CONSTRAINT FK_o59c42r6l2dgqgux6bkg0hl52 FOREIGN KEY(empleado1_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
-- ALTER TABLE cambio_turno CHECK CONSTRAINT FK_o59c42r6l2dgqgux6bkg0hl52
-- GO
/****** Object:  ForeignKey fk_cambio_turno__turno_2    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE cambio_turno  WITH CHECK ADD  CONSTRAINT fk_cambio_turno__turno_2 FOREIGN KEY(turno2_id)
REFERENCES turno (id)
GO
ALTER TABLE cambio_turno CHECK CONSTRAINT fk_cambio_turno__turno_2
GO
/****** Object:  ForeignKey FK_3gil57nrectpcxspmrby6gj1v    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE compra_vacacion  WITH CHECK ADD  CONSTRAINT FK_3gil57nrectpcxspmrby6gj1v FOREIGN KEY(empleado_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
-- ALTER TABLE compra_vacacion CHECK CONSTRAINT FK_3gil57nrectpcxspmrby6gj1v
-- GO
/****** Object:  ForeignKey fk_compra_vacacion_periodo    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE compra_vacacion  WITH CHECK ADD  CONSTRAINT fk_compra_vacacion_periodo FOREIGN KEY(periodo_anio)
REFERENCES Periodo (anio)
GO
ALTER TABLE compra_vacacion CHECK CONSTRAINT fk_compra_vacacion_periodo
GO
/****** Object:  ForeignKey FK_7d8gur0piachefir50h1w98px    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE detalle_grupo_horario  WITH CHECK ADD  CONSTRAINT FK_7d8gur0piachefir50h1w98px FOREIGN KEY(empleado_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
-- ALTER TABLE detalle_grupo_horario CHECK CONSTRAINT FK_7d8gur0piachefir50h1w98px
-- GO
/****** Object:  ForeignKey fk_detalle_grupo_horario__grupo_horario    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE detalle_grupo_horario  WITH CHECK ADD  CONSTRAINT fk_detalle_grupo_horario__grupo_horario FOREIGN KEY(grupo_horario_codigo)
REFERENCES grupo_horario (codigo)
GO
ALTER TABLE detalle_grupo_horario CHECK CONSTRAINT fk_detalle_grupo_horario__grupo_horario
GO
/****** Object:  ForeignKey fk__asistencia__detalle_jornada__asistencia__jornada__jorn_codigo    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE detalle_jornada  WITH CHECK ADD  CONSTRAINT fk__asistencia__detalle_jornada__asistencia__jornada__jorn_codigo FOREIGN KEY(jorn_codigo)
REFERENCES Jornada (codigo)
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE detalle_jornada CHECK CONSTRAINT fk__asistencia__detalle_jornada__asistencia__jornada__jorn_codigo
GO
/****** Object:  ForeignKey fk__asistencia__detalle_registro_asistencia__asistencia__detalle_jornada__dtjorn_id    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE detalle_registro_asistencia  WITH CHECK ADD  CONSTRAINT fk__asistencia__detalle_registro_asistencia__asistencia__detalle_jornada__dtjorn_id FOREIGN KEY(dtjorn_id)
REFERENCES detalle_jornada (dtjorn_id)
GO
ALTER TABLE detalle_registro_asistencia CHECK CONSTRAINT fk__asistencia__detalle_registro_asistencia__asistencia__detalle_jornada__dtjorn_id
GO
/****** Object:  ForeignKey fk_detalle_registro_asistencia__permiso    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE detalle_registro_asistencia  WITH CHECK ADD  CONSTRAINT fk_detalle_registro_asistencia__permiso FOREIGN KEY(permiso_id)
REFERENCES Permiso (id)
GO
ALTER TABLE detalle_registro_asistencia CHECK CONSTRAINT fk_detalle_registro_asistencia__permiso
GO
/****** Object:  ForeignKey FK_byr10a0yxvobid4ikty3pbhvn    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE Feriado  WITH CHECK ADD  CONSTRAINT FK_byr10a0yxvobid4ikty3pbhvn FOREIGN KEY(periodo_anio)
-- REFERENCES Periodo (anio)
-- GO
-- ALTER TABLE Feriado CHECK CONSTRAINT FK_byr10a0yxvobid4ikty3pbhvn
-- GO
/****** Object:  ForeignKey fk_permiso__tipo_permiso    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE Permiso  WITH CHECK ADD  CONSTRAINT fk_permiso__tipo_permiso FOREIGN KEY(tipo_permiso_codigo)
REFERENCES tipo_permiso (codigo)
GO
ALTER TABLE Permiso CHECK CONSTRAINT fk_permiso__tipo_permiso
GO
/****** Object:  ForeignKey fk__asistencia__registro_asistencia__asistencia__jornada__jornada_codigo    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE registro_asistencia  WITH CHECK ADD  CONSTRAINT fk__asistencia__registro_asistencia__asistencia__jornada__jornada_codigo FOREIGN KEY(jornada_codigo)
REFERENCES Jornada (codigo)
GO
ALTER TABLE registro_asistencia CHECK CONSTRAINT fk__asistencia__registro_asistencia__asistencia__jornada__jornada_codigo
GO
/****** Object:  ForeignKey FK__registro___emple__71D1E811    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE registro_asistencia  WITH CHECK ADD FOREIGN KEY(empleado_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
/****** Object:  ForeignKey FK__registro___feria__72C60C4A    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE registro_asistencia  WITH CHECK ADD FOREIGN KEY(feriado_fecha_inicio)
REFERENCES Feriado (fecha_inicio)
GO
/****** Object:  ForeignKey FK__registro___horar__73BA3083    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE registro_asistencia  WITH CHECK ADD FOREIGN KEY(horario_codigo)
REFERENCES Horario (codigo)
GO
/****** Object:  ForeignKey FK__registro___permi__74AE54BC    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE registro_asistencia  WITH CHECK ADD FOREIGN KEY(permiso_id)
REFERENCES Permiso (id)
GO
/****** Object:  ForeignKey FK__registro___vacac__75A278F5    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE registro_asistencia  WITH CHECK ADD FOREIGN KEY(vacacion_id)
REFERENCES Vacacion (id)
GO
/****** Object:  ForeignKey FK_mk85sj4nd0lmmlbgcayfue0ik    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE rol_acceso  WITH CHECK ADD  CONSTRAINT FK_mk85sj4nd0lmmlbgcayfue0ik FOREIGN KEY(rol_codigo)
-- REFERENCES Rol (codigo)
-- GO
-- ALTER TABLE rol_acceso CHECK CONSTRAINT FK_mk85sj4nd0lmmlbgcayfue0ik
-- GO
/****** Object:  ForeignKey FK_okl7mvw0x8jfrlr0lws1ky70d    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE rol_acceso  WITH CHECK ADD  CONSTRAINT FK_okl7mvw0x8jfrlr0lws1ky70d FOREIGN KEY(acceso_id)
-- REFERENCES Acceso (id)
-- GO
-- ALTER TABLE rol_acceso CHECK CONSTRAINT FK_okl7mvw0x8jfrlr0lws1ky70d
-- GO
/****** Object:  ForeignKey fk_saldo_vacacional__periodo    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE saldo_vacacional  WITH CHECK ADD  CONSTRAINT fk_saldo_vacacional__periodo FOREIGN KEY(periodo_anio)
REFERENCES Periodo (anio)
GO
ALTER TABLE saldo_vacacional CHECK CONSTRAINT fk_saldo_vacacional__periodo
GO
/****** Object:  ForeignKey FK_ib927c3tp828xgye0y4h8nyxs    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE saldo_vacacional  WITH CHECK ADD  CONSTRAINT FK_ib927c3tp828xgye0y4h8nyxs FOREIGN KEY(empleado_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
-- ALTER TABLE saldo_vacacional CHECK CONSTRAINT FK_ib927c3tp828xgye0y4h8nyxs
-- GO
/****** Object:  ForeignKey fk__asistencia__turno__asistencia__horario__horario_codigo    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE turno  WITH CHECK ADD  CONSTRAINT fk__asistencia__turno__asistencia__horario__horario_codigo FOREIGN KEY(horario_codigo)
REFERENCES Horario (codigo)
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE turno CHECK CONSTRAINT fk__asistencia__turno__asistencia__horario__horario_codigo
GO
/****** Object:  ForeignKey fk__asistencia__turno__asistencia__jornada__jornada_codigo    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE turno  WITH CHECK ADD  CONSTRAINT fk__asistencia__turno__asistencia__jornada__jornada_codigo FOREIGN KEY(jornada_codigo)
REFERENCES Jornada (codigo)
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE turno CHECK CONSTRAINT fk__asistencia__turno__asistencia__jornada__jornada_codigo
GO
/****** Object:  ForeignKey FK_6r5r02aqm476c1ta1dyjn16r2    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE Usuario  WITH CHECK ADD  CONSTRAINT FK_6r5r02aqm476c1ta1dyjn16r2 FOREIGN KEY(empleado_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
-- ALTER TABLE Usuario CHECK CONSTRAINT FK_6r5r02aqm476c1ta1dyjn16r2
-- GO
/****** Object:  ForeignKey FK_m40q1tg14fpiq9pm2vcwekjnc    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE Usuario  WITH CHECK ADD  CONSTRAINT FK_m40q1tg14fpiq9pm2vcwekjnc FOREIGN KEY(rol_codigo)
-- REFERENCES Rol (codigo)
-- GO
-- ALTER TABLE Usuario CHECK CONSTRAINT FK_m40q1tg14fpiq9pm2vcwekjnc
-- GO
/****** Object:  ForeignKey fk_vacacion__periodo    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE Vacacion  WITH CHECK ADD  CONSTRAINT fk_vacacion__periodo FOREIGN KEY(periodo_anio)
REFERENCES Periodo (anio)
GO
ALTER TABLE Vacacion CHECK CONSTRAINT fk_vacacion__periodo
GO
/****** Object:  ForeignKey fk_vacacion__vacacion    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE Vacacion  WITH CHECK ADD  CONSTRAINT fk_vacacion__vacacion FOREIGN KEY(vacacion_id)
REFERENCES Vacacion (id)
GO
ALTER TABLE Vacacion CHECK CONSTRAINT fk_vacacion__vacacion
GO
/****** Object:  ForeignKey FK_m3t5v1175x7o88sb9doj2cv5r    Script Date: 02/24/2016 20:26:54 ******/
-- ALTER TABLE Vacacion  WITH CHECK ADD  CONSTRAINT FK_m3t5v1175x7o88sb9doj2cv5r FOREIGN KEY(empleado_nro_documento)
-- REFERENCES personal.persona (nro_documento)
-- GO
-- ALTER TABLE Vacacion CHECK CONSTRAINT FK_m3t5v1175x7o88sb9doj2cv5r
-- GO
/****** Object:  ForeignKey FK__area__area_super__160F4887    Script Date: 02/24/2016 20:26:54 ******/
ALTER TABLE institucional.area  WITH CHECK ADD FOREIGN KEY(area_superior_id)
REFERENCES institucional.area (area_id)
GO

/****** Object:  View biostar.v_marcaciones    Script Date: 02/24/2016 20:26:56 ******/
CREATE VIEW biostar.v_marcaciones AS 
SELECT     reporte.nEventLogIdn AS id, usuario.sUserID AS empleado_nro_documento, usuario.sUserName AS empleado_nombre, equipo.sName AS equipo_ip, DATEADD(s, reporte.nDateTime, '1970-01-01') 
                      AS fecha_hora, CONVERT(DATE, DATEADD(s, reporte.nDateTime, '1970-01-01')) AS fecha, CONVERT(TIME, DATEADD(s, reporte.nDateTime, '1970-01-01')) AS hora, reporte.nEventIdn AS evento
FROM         db_biostar.dbo.TB_USER AS usuario INNER JOIN
                      db_biostar.dbo.TB_EVENT_LOG AS reporte ON usuario.sUserID = reporte.nUserID INNER JOIN
                      db_biostar.dbo.TB_READER AS equipo ON reporte.nReaderIdn = equipo.nReaderIdn
WHERE     (reporte.nEventIdn IN ('41', '43', '44', '45', '46', '47', '48', '49', '50', '51', '52', '53', '55'))
GO
/****** Object:  View biostar.v_enrolados    Script Date: 02/24/2016 20:26:56 ******/
CREATE VIEW biostar.v_enrolados AS 
SELECT
DISTINCT(usuario.sUserID) as empleado_nro_documento
FROM
db_biostar.dbo.TB_USER_TEMPLATE temp
INNER JOIN db_biostar.dbo.TB_USER usuario ON temp.nUserIdn = usuario.nUserIdn
GO



/***
CAMBIAR NOMBRES DE LOS FK'S
VER CREACION DE SCHEMAS - LISTO


REVISAR VIEW DE CREACION DE MARCACIONES NO LIGARLO A PERSONAL -LISTO
***/