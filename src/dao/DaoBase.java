package dao;


public abstract class DaoBase<T> {
	
	protected static final String FORNECEDOR = "fornecedor";
	protected static final String PESSOA = "pessoa";
	protected static final String PRODUTO = "produto";
	protected static final String VENDA = "venda";
	protected static final String DATABASE = "test";
	
	public abstract T save(T obj);
	public abstract void update(T obj);
	public abstract T get(String objectId);

}
