/**
	MIGRACION DE VACACIONES_OLD A VACACIONES
**/
SET IDENTITY_INSERT dbo.Vacacion ON;
GO
INSERT INTO  dbo.Vacacion
           ([id]
           ,[documento]
           ,[documento_reprogramacion]
           ,[fecha_fin]
           ,[fecha_inicio]
           ,[fecha_interrupcion]
           ,[hay_interrupcion]
           ,[hay_reprogramacion]
           ,[empleado_nro_documento]
           ,[periodo_anio]
           ,[vacacion_id]
           ,[resolucion]
           ,[sinad]
           ,[observacion]
           ,[reprogramacion_total]) 
SELECT [id]
      ,[documento]
      ,[documento_reprogramacion]
      ,[fecha_fin]
      ,[fecha_inicio]
      ,[fecha_interrupcion]
      ,[hay_interrupcion]
      ,[hay_reprogramacion]
      ,[empleado_nro_documento]
      ,[periodo_anio]
      ,[vacacion_id]
      ,[resolucion]
      ,[sinad]
      ,[observacion]
      ,[reprogramacion_total]
  FROM dbo.Vacacion_old
GO
SET IDENTITY_INSERT dbo.Vacacion OFF;
GO

/**
	MIGRACION DE SALDOS VACACIONES_OLD A SALDOS VACACIONES
**/
SET IDENTITY_INSERT dbo.saldo_vacacional ON;
GO
INSERT INTO  dbo.saldo_vacacional
           ([id]
           ,[dias_restantes]
           ,[domingo]
           ,[fecha_desde]
           ,[fecha_hasta]
           ,[lunes_viernes]
           ,[sabado]
           ,[empleado_nro_documento]
           ,[periodo_anio]) 
SELECT		[id]
		   ,[dias_restantes]
           ,[domingo]
           ,[fecha_desde]
           ,[fecha_hasta]
           ,[lunes_viernes]
           ,[sabado]
           ,[empleado_nro_documento]
           ,[periodo_anio]
  FROM dbo.saldo_vacacional_old
GO
SET IDENTITY_INSERT dbo.saldo_vacacional OFF;
GO

/**
  MIGRACION DE TIPO PERMISOS_OLD A TIPO PERMISOS
**/
INSERT INTO  dbo.tipo_permiso
           ([codigo]
           ,[clase]
           ,[diasMaximo]
           ,[nombre]
           ,[tipo_descuento])
SELECT      [codigo]
           ,[clase]
           ,[diasMaximo]
           ,[nombre]
           ,[tipo_descuento]
  FROM dbo.tipo_permiso_old
GO

/**
  MIGRACION DE PERMISOS_OLD A PERMISOS
**/
SET IDENTITY_INSERT dbo.Permiso ON;
GO
INSERT INTO  dbo.Permiso
           ([id]
           ,[a_compensar]
           ,[cubre_entrada]
           ,[cubre_salida]
           ,[diferencia_minutos]
           ,[documento]
           ,[fecha_fin]
           ,[fecha_inicio]
           ,[hora_fin]
           ,[hora_inicio]
           ,[motivo]
           ,[opcion]
           ,[por_fecha]
           ,[tipo_permiso_codigo])
SELECT     
      [id]
       ,[a_compensar]
           ,[cubre_entrada]
           ,[cubre_salida]
           ,[diferencia_minutos]
           ,[documento]
           ,[fecha_fin]
           ,[fecha_inicio]
           ,[hora_fin]
           ,[hora_inicio]
           ,[motivo]
           ,[opcion]
           ,[por_fecha]
           ,[tipo_permiso_codigo]
  FROM dbo.Permiso_old
GO
SET IDENTITY_INSERT dbo.Permiso OFF;
GO

/**
  MIGRACION DE ASIGNACION_PERMISOS_OLD A ASIGNACION_PERMISOS
**/
SET IDENTITY_INSERT dbo.asignacion_permiso ON;
GO
INSERT INTO  dbo.asignacion_permiso 
           ([id]
           ,[empleado_nro_documento]
           ,[permiso_id])
SELECT    [id]
           ,[empleado_nro_documento]
           ,[permiso_id]
  FROM dbo.asignacion_permiso_old 
GO
SET IDENTITY_INSERT dbo.asignacion_permiso  OFF;
GO

/**
  MIGRACION DE GRUPOS_HORARIOS_OLD A GRUPOS_HORARIOS
**/
INSERT INTO  dbo.grupo_horario 
           ([codigo]
           ,[nombre])
SELECT      [codigo]
           ,[nombre]
  FROM dbo.grupo_horario_old 
GO

/**
  MIGRACION DE DETALLE_GRUPO_HORARIO_OLD A DETALLE_GRUPO_HORARIO
**/
SET IDENTITY_INSERT dbo.detalle_grupo_horario ON;
GO
INSERT INTO  dbo.detalle_grupo_horario 
           ([id]
           ,[empleado_nro_documento]
           ,[grupo_horario_codigo])
SELECT      [id]
           ,[empleado_nro_documento]
           ,[grupo_horario_codigo]
  FROM dbo.detalle_grupo_horario_old 
GO
SET IDENTITY_INSERT dbo.detalle_grupo_horario  OFF;
GO

/**
  MIGRACION DE HORARIO_OLD A HORARIO
**/
INSERT INTO  dbo.Horario 
           ([codigo]
           ,[documento]
           ,[nombre]
           ,[tipo])
SELECT      [codigo]
           ,[documento]
           ,[nombre]
           ,NULL
  FROM dbo.Horario_old
GO

/**
  MIGRACION DE ASIGNACION_HORARIO_OLD A ASIGNACION_HORARIO
**/
SET IDENTITY_INSERT dbo.asignacion_horario ON;
GO
INSERT INTO  dbo.asignacion_horario 
           ([id]
           ,[por_grupo]
           ,[empleado_nro_documento]
           ,[grupo_horario_codigo]
           ,[horario_codigo]
           ,[fecha_inicio]
           ,[fecha_fin])
SELECT      [id]
           ,[por_grupo]
           ,[empleado_nro_documento]
           ,[grupo_horario_codigo]
           ,[horario_codigo]
           ,[fecha_inicio]
           ,[fecha_fin]
  FROM dbo.asignacion_horario_old 
GO
SET IDENTITY_INSERT dbo.asignacion_horario  OFF;
GO

/**
  MIGRACION DE JORNADA_OLD A JORNADA
**/
INSERT INTO  dbo.Jornada 
           ([codigo]
           ,[nombre]
           ,[tipo]
           ,[descripcion]
           ,[activo])
SELECT      [codigo]
           ,[nombre]
           ,'A'
           ,NULL
           ,1
  FROM dbo.Jornada_old 
GO

/**
  MIGRACION DE JORNADA_OLD A DETALLE_JORNADA
**/

--Detalle 1
INSERT INTO  dbo.detalle_jornada 
           ([dtjorn_entrada]
           ,[dtjorn_entrada_desde]
           ,[dtjorn_entrada_hasta]
           ,[dtjorn_entrada_tolerancia]
           ,[dtjorn_salida]
           ,[dtjorn_salida_desde]
           ,[dtjorn_salida_hasta]
           ,[dtjorn_salida_dia_siguiente]
           ,[jorn_codigo])
SELECT      [turno_he]
           ,[desde_marcacion_he]
           ,[refrigerio_hs]
           ,[tolerancia_turno_he]
           ,[refrigerio_hs]
           ,[refrigerio_hs]
           ,[refrigerio_hs]
           ,0
           ,[codigo]
  FROM dbo.Jornada_old 
GO
--POR REVISAR

--Detalle 2
INSERT INTO  dbo.detalle_jornada 
           ([dtjorn_entrada]
           ,[dtjorn_entrada_desde]
           ,[dtjorn_entrada_hasta]
           ,[dtjorn_entrada_tolerancia]
           ,[dtjorn_salida]
           ,[dtjorn_salida_desde]
           ,[dtjorn_salida_hasta]
           ,[dtjorn_salida_dia_siguiente]
           ,[jorn_codigo])
SELECT       [refrigerioHE]
      ,[refrigerioHE]
      ,[turno_hs]
      ,[refrigerioHE]
      ,[turno_hs]
      ,[turno_hs]
      ,'23:59:00'
      ,0
      ,[codigo]
  FROM dbo.Jornada_old 
GO
--Revisar***

/**
  MIGRACION DE HORARIOS A TURNO
**/
INSERT INTO  dbo.turno
           ([domingo]
           ,[fecha_inicio]
           ,[jueves]
           ,[lunes]
           ,[martes]
           ,[miercoles]
           ,[sabado]
           ,[tipo]
           ,[viernes]
           ,[horario_codigo]
           ,[jornada_codigo]
           ,[fecha_fin])
SELECT      [domingo]
           ,[fecha_inicio]
           ,[jueves]
           ,[lunes]
           ,[martes]
           ,[miercoles]
           ,[sabado]
           ,'S'
           ,[viernes]
           ,[codigo]
           ,[jornada_codigo]
           ,[fecha_fin]
  FROM dbo.Horario_old
GO