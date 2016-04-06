import util.GrupoProduto;
import util.TipoPessoa;
import model.Fornecedor;
import model.NotaFiscal;
import model.Pessoa;
import model.Produto;
import model.Venda;
import dao.FornecedorDAO;
import dao.NotaFiscalDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;


public class main {

	public static void main(String[] args) {
		
		PessoaDAO pdao = new PessoaDAO();
		FornecedorDAO fdao = new FornecedorDAO();
		ProdutoDAO prdao = new ProdutoDAO();
		NotaFiscalDAO nfdao = new NotaFiscalDAO();
		VendaDAO vdao = new VendaDAO();
		
		/**Exemplo Salva Pessoa Cliente e Fornecedor e Funcionario*/
		Pessoa p = new Pessoa();
		p.setNome("TiagoSG");
		p.setTipoPessoa(TipoPessoa.Cliente);
		p = pdao.save(p);
		String idpessoa = p.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Pessoa Cliente<<<<<<<<<<<<<<<<<<");
		System.out.println(p.toString());
		
		p = new Pessoa();
		p.setNome("TiagoSG 2");
		p.setTipoPessoa(TipoPessoa.Fornecedor);
		p = pdao.save(p);
		String idPessoaFornecedor = p.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Pessoa Fornecedor<<<<<<<<<<<<<<<<<<");
		System.out.println(p.toString());
		
		
		p = new Pessoa();
		p.setNome("TiagoSG 3");
		p.setTipoPessoa(TipoPessoa.Funcionario);
		p = pdao.save(p);
		String idPessoaFuncionario = p.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Pessoa Funcionarior<<<<<<<<<<<<<<<<<<");
		System.out.println(p.toString());
		
		
		p = new Pessoa();
		p.setNome("TiagoSG 4");
		p.setTipoPessoa(TipoPessoa.Cliente);
		p = pdao.save(p);
		String idPessoaCliente = p.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Pessoa Cliente 2<<<<<<<<<<<<<<<<<<");
		System.out.println(p.toString());
		
		
		/**Exemplo Find Pessoa*/
		p = pdao.get(idpessoa);
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Find Pessoa Cliente<<<<<<<<<<<<<<<<<<");
		System.out.println(p.toString());
		
		/**Exemplo Salva Fornecedor*/
		Fornecedor f = new Fornecedor();
		f.setCpnj("999999999");
		p = pdao.get(idPessoaFornecedor); //get Pessoa Fornecedor
		f.setPessoaId(p);
		f = fdao.save(f);
		String fornecedorId = f.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Fornecedor<<<<<<<<<<<<<<<<<<");
		System.out.println(f.toString());
		
		
		/**Exemplo Find Fornecedor*/
		f = fdao.get(fornecedorId);
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Find Fornecedor<<<<<<<<<<<<<<<<<<");
		System.out.println(f.toString());
		
		/**Exemplo UPDATE Pessoa*/
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>UPDATE Pessoa<<<<<<<<<<<<<<<<<<");
		p = pdao.get(idpessoa);
		System.out.println(p.toString()); //mostro antes do update
		p.setTipoPessoa(TipoPessoa.Fornecedor);
		pdao.update(p);
		p = pdao.get(idpessoa);
		System.out.println(p.toString());
		
		/**Exemplo Salva Produto*/
		Produto pr = new Produto();
		pr.setNome("TV Sansung");
		pr.setDescrição("40 Polegadas Full HD SmartTV");
		pr.setGrupoProduto(GrupoProduto.Eletronicos);
		f = fdao.get(fornecedorId);
		pr.setFornecedorId(f);
		pr = prdao.save(pr);
		String produtoId = pr.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Produto<<<<<<<<<<<<<<<<<<");
		System.out.println(pr.toString());
		
		/**Exemplo Salva NotaFiscal*/
		NotaFiscal nf = new NotaFiscal();
		nf.setImposto(5.0);
		nf = nfdao.save(nf);
		String notaFiscalId = nf.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva NotaFiscal<<<<<<<<<<<<<<<<<<");
		System.out.println(nf.toString());
		
		/**Exemplo Salva Venda*/
		Venda v = new Venda();
		Pessoa pc = pdao.get(idPessoaCliente); //Pessoa Cliente
		Pessoa pf = pdao.get(idPessoaFuncionario); //Pessoa Funcionario
		pr = prdao.get(produtoId); //Produto
		nf = nfdao.get(notaFiscalId); //NotaFiscal;
		v.setPessoaId_cliente(pc);
		v.setPessoaId_funcionario(pf);
		v.setProdutoId(pr);
		v.setNota_fiscal(nf);
		v.setValor_venda(1999.99);
		v = vdao.save(v);
		String vendaid = v.getId();
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Salva Venda<<<<<<<<<<<<<<<<<<");
		System.out.println(v.toString());
		
		/**Exemplo Find Venda*/
		v = vdao.get(vendaid);
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>Find Venda<<<<<<<<<<<<<<<<<<");
		System.out.println(v.toString());
		
		/**Exemplo de Update Cascata das coleções*/
		System.out.println(">>>>>>>>>>>>>>>>>Exemplo Get Atualização em Cascata<<<<<<<<<<<<<<<<<<");
		pc = pdao.get(idPessoaCliente); //Pessoa Cliente
		pf = pdao.get(idPessoaFuncionario); //Pessoa Funcionario
		
		/**Mostro antes da mudança*/
		System.out.println(pc.toString());
		System.out.println(pf.toString());
		
		pc.setNome("Mudei nome Cliente");
		pf.setNome("Mudei nome Funcionario");
		pdao.update(pc);
		pdao.update(pf);
		
		pc = pdao.get(idPessoaCliente);
		pf = pdao.get(idPessoaFuncionario);
		
		/**Mostro que mudou*/
		System.out.println(pc.toString());
		System.out.println(pf.toString());
		
		/**
		 * Neste momento existe uma inconsistencia entre Venda e Pessoa Cliente e Pessoa Funcionario no Banco.
		 **/
		v = vdao.get(vendaid); //se o hash tiver diferentes entre as coleções ele faz updates necessarios.
		System.out.println(v.toString()); //ja retornou atualizado!
		
		
		System.out.println(">>>>>>>>>>>>>>>>>Exemplo Deletar<<<<<<<<<<<<<<<<<<");
		p=pdao.get(idpessoa);
		System.out.println(p.toString()); 
		pdao.delete(idpessoa);
		p=pdao.get(idpessoa);
		System.out.println(p.toString()); //Exception NullPointerException 
	}
}
