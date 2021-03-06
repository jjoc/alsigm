package ieci.core.db;

public final class DbTableFns {

	private DbTableFns() {
	}

	public static void createTable(DbConnection conn, String tblName,
			DbColumnDef[] colDefs) throws Exception {

		String stmtText;

		stmtText = getCreateTableStmtText(tblName, colDefs, conn.getEngine());

		DbUtil.executeStatement(conn, stmtText);

	}

	public static void truncateTable(DbConnection conn, String tblName)
			throws Exception {

		String stmtText;

		stmtText = getTruncateTableStmtText(tblName);

		DbUtil.executeStatement(conn, stmtText);

	}

	public static void createTable(DbConnection conn, String tblName,
			DbColumnDef[] colDefs, DbIndexDef[] indexDefs) throws Exception {
		createTable(conn, tblName, colDefs);
		createIndices(conn, tblName, indexDefs);
	}

	public static void dropTable(DbConnection conn, String tblName)
			throws Exception {

		String stmtText;

		stmtText = getDropTableStmtText(tblName);

		DbUtil.executeStatement(conn, stmtText);

	}

	public static void createIndices(DbConnection conn, String tblName,
			DbIndexDef[] indexDefs) throws Exception {

		int count, i;

		count = indexDefs.length;

		for (i = 0; i < count; i++)
			createIndex(conn, tblName, indexDefs[i]);

	}

	public static void dropIndices(DbConnection conn, String tblName,
			DbIndexDef[] indexDefs) throws Exception {

		int count, i;

		count = indexDefs.length;

		for (i = 0; i < count; i++)
			dropIndex(conn, tblName, indexDefs[i].getName());

	}

	public static void createIndex(DbConnection conn, String tblName,
			DbIndexDef indexDef) throws Exception {

		String stmtText;

		stmtText = getCreateIndexStmtText(tblName, indexDef);

		DbUtil.executeStatement(conn, stmtText);

	}

	public static void dropIndex(DbConnection conn, String tblName,
			String indexName) throws Exception {

		String stmtText;

		stmtText = getDropIndexStmtText(tblName, indexName, conn.getEngine());

		DbUtil.executeStatement(conn, stmtText);

	}

	// **************************************************************************

	private static String getCreateTableStmtText(String tblName,
			DbColumnDef[] colDefs, int engine) throws Exception {

		StringBuffer tbdr;
		int count, i;
		DbColumnDef colDef;
		int dataType;

		tbdr = new StringBuffer();

		tbdr.append("CREATE TABLE ").append(tblName).append(" (");

		count = colDefs.length;

		for (i = 0; i < count; i++) {

			colDef = colDefs[i];
			dataType = colDef.getDataType();

			if (i > 0)
				tbdr.append(",");

			tbdr.append(colDef.getName());
			tbdr.append(" ");
			tbdr.append(DbDataType.getNativeDbType(dataType, engine));

			if (dataType == DbDataType.SHORT_TEXT)
				tbdr.append("(").append(colDef.getMaxLen()).append(")");

			if (!colDef.isNullable())
				tbdr.append(" NOT NULL");

		}

		tbdr.append(")");

		return tbdr.toString();

	}

	private static String getDropTableStmtText(String tblName) {

		StringBuffer tbdr;

		tbdr = new StringBuffer();

		tbdr.append("DROP TABLE ").append(tblName);

		return tbdr.toString();

	}

	private static String getTruncateTableStmtText(String tblName) {

		StringBuffer tbdr;

		tbdr = new StringBuffer();

		tbdr.append("TRUNCATE TABLE ").append(tblName);

		return tbdr.toString();

	}

	private static String getCreateIndexStmtText(String tblName,
			DbIndexDef indexDef) {

		StringBuffer tbdr;

		tbdr = new StringBuffer();

		if (indexDef.isUnique())
			tbdr.append("CREATE UNIQUE INDEX ");
		else
			tbdr.append("CREATE INDEX ");

		tbdr.append(indexDef.getName()).append(" ON ").append(tblName);
		tbdr.append(" (").append(indexDef.getColumnNames()).append(")");

		return tbdr.toString();

	}

	private static String getDropIndexStmtText(String tblName,
			String indexName, int engine) {

		StringBuffer tbdr;

		tbdr = new StringBuffer();

		tbdr.append("DROP INDEX ");

		if (engine == DbEngine.SQLSERVER)
			tbdr.append(tblName).append(".").append(indexName);
		else
			tbdr.append(indexName);

		return tbdr.toString();

	}

} // class
