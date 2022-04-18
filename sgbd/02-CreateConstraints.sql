ALTER TABLE benchmarksql.materias ADD CONSTRAINT pk_materias
	PRIMARY KEY (m_sigla);
	
ALTER TABLE benchmarksql.grupos ADD CONSTRAINT pk_grupos
	PRIMARY KEY (g_id);
	
ALTER TABLE benchmarksql.estudiantes ADD CONSTRAINT pk_estudiantes
	PRIMARY KEY (e_id);
	
ALTER TABLE benchmarksql.salones ADD CONSTRAINT pk_salones
	PRIMARY KEY (s_id);
	
ALTER TABLE benchmarksql.salongrupo ADD CONSTRAINT pk_salongrupo
	PRIMARY KEY (sg_s_id, sg_g_id);

ALTER TABLE benchmarksql.grupoestudiante ADD CONSTRAINT pk_grupoestudiante
	PRIMARY KEY (ge_e_id, ge_g_ig);
	
ALTER TABLE benchmarksql.grupos ADD CONSTRAINT fk_materia_grupo
	FOREIGN KEY (g_m_id) REFERENCES benchmarksql.materias(m_sigla);
	
ALTER TABLE benchmarksql.salongrupo ADD CONSTRAINT fk_salongrupo_salon
	FOREIGN KEY (sg_s_id) REFERENCES benchmarksql.salones(s_id);
	
ALTER TABLE benchmarksql.salongrupo ADD CONSTRAINT fk_salongrupo_grupo
	FOREIGN KEY (sg_g_id) REFERENCES benchmarksql.grupos(g_id);
	
ALTER TABLE benchmarksql.grupoestudiante ADD CONSTRAINT fk_grupoestudiante_estudiante
	FOREIGN KEY (ge_e_id) REFERENCES benchmarksql.estudiantes(e_id);
	
ALTER TABLE benchmarksql.grupoestudiante ADD CONSTRAINT fk_grupoestudiante_grupo
	FOREIGN KEY (ge_g_id) REFERENCES benchmarksql.grupos(g_id);

CREATE INDEX ndx_materias_nombre
	ON benchmarksql.materias (m_sigla, m_nombre, m_creditos);
	
CREATE INDEX ndx_grupos_numero
	ON benchmarksql.grupos(g_id, g_numero, g_m_id);
	
CREATE INDEX ndx_salongrupo_relation
	ON benchmarksql.salongrupo(sg_s_id, sg_g_id);
	
CREATE INDEX ndx_grupoestudiante_relation
	ON benchmarksql.grupoestudiante(ge_e_id, ge_g_id);