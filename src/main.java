import util.GrupoProduto;
import util.TipoPessoa;
import model.Fornecedor;
import model.Pessoa;
import model.Produto;
import dao.FornecedorDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;


public class main {

	public static void main(String[] args) {
		
		PessoaDAO pdao = new PessoaDAO();
		FornecedorDAO fdao = new FornecedorDAO();
		ProdutoDAO prdao = new ProdutoDAO();
		
		/**Exemplo Salva Pessoa Cliente e Fornecedor*/
		Pessoa p = new Pessoa();
		p.setNome("TiagoSG");
		p.setTipoPessoa(TipoPessoa.Cliente);
		p = pdao.save(p);
		String idpessoa = p.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Pessoa Cliente<<<<<<<<<<<<<<<<<<");
		System.out.println("ID: "+p.getId()); //ID Pessoa Cliente
		System.out.println("Nome: "+p.getNome());
		System.out.println("Tipo: "+p.getTipoPessoa());
		
		p = new Pessoa();
		p.setNome("TiagoSG 2");
		p.setTipoPessoa(TipoPessoa.Fornecedor);
		p = pdao.save(p);
		String idPessoaFornecedor = p.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Pessoa Fornecedor<<<<<<<<<<<<<<<<<<");
		System.out.println("ID: "+p.getId()); //ID Pessoa Fornecedor
		System.out.println("Nome: "+p.getNome());
		System.out.println("Tipo: "+p.getTipoPessoa());
		
		/**Exemplo Find Pessoa*/
		p = pdao.get(idpessoa);
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Find Pessoa Cliente<<<<<<<<<<<<<<<<<<");
		System.out.println("ID: "+p.getId());
		System.out.println("Nome: "+p.getNome());
		System.out.println("Tipo: "+p.getTipoPessoa());
		
		/**Exemplo Fornecedor Salva*/
		Fornecedor f = new Fornecedor();
		f.setCpnj("999999999");
		p = pdao.get(idPessoaFornecedor); //get Pessoa Fornecedor
		f.setPessoaId(p);
		f = fdao.save(f);
		String fornecedorId = f.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Fornecedor<<<<<<<<<<<<<<<<<<");
		System.out.println("ID Fornecedor: "+f.getId());
		System.out.println("CPNJ: "+f.getCpnj());
		System.out.println("ID Pessoa: "+f.getPessoaId().getId());
		System.out.println("Nome: "+f.getPessoaId().getNome());
		System.out.println("Tipo: "+f.getPessoaId().getTipoPessoa());
		
		
		/**Exemplo Fornecedor Find*/
		f = fdao.get(fornecedorId);
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Find Fornecedor<<<<<<<<<<<<<<<<<<");
		System.out.println("ID: "+f.getId());
		System.out.println("CPNJ: "+f.getCpnj());
		System.out.println("ID Pessoa: "+f.getPessoaId().getId());
		System.out.println("Nome: "+f.getPessoaId().getNome());
		System.out.println("Tipo: "+f.getPessoaId().getTipoPessoa());
		
		/**Exemplo Pessoa UPDATE*/
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>UPDATE Pessoa<<<<<<<<<<<<<<<<<<");
		p = pdao.get(idpessoa);
		System.out.println("ID: "+p.getId());
		System.out.println("Nome: "+p.getNome());
		System.out.println("Tipo: "+p.getTipoPessoa()); 
		p.setTipoPessoa(TipoPessoa.Fornecedor);
		pdao.update(p);
		p = pdao.get(idpessoa);
		System.out.println("ID: "+p.getId());
		System.out.println("Nome: "+p.getNome());
		System.out.println("Tipo: "+p.getTipoPessoa());
		
		/**Exemplo Produto Salva*/
		Produto pr = new Produto();
		pr.setNome("TV Sansung");
		pr.setDescrição("40 Polegadas Full HD SmartTV");
		pr.setGrupoProduto(GrupoProduto.Eletronicos);
		f = fdao.get(fornecedorId);
		pr.setFornecedorId(f);
		pr = prdao.save(pr);
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Produto<<<<<<<<<<<<<<<<<<");
		System.out.println("ID: "+pr.getId());
		System.out.println("Nome: "+pr.getNome());
		System.out.println("Descrição: "+pr.getDescrição());
		System.out.println("Grupo Produto: "+pr.getGrupoProduto());
		System.out.println("ID Fornecedor: "+pr.getFornecedorId().getId());
		System.out.println("Nome Fornecedor: "+pr.getFornecedorId().getPessoaId().getNome());
		
	}
}
