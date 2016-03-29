import util.TipoPessoa;
import model.Fornecedor;
import model.Pessoa;
import dao.FornecedorDAO;
import dao.PessoaDAO;


public class main {

	public static void main(String[] args) {
		
		PessoaDAO pdao = new PessoaDAO();
		FornecedorDAO fdao = new FornecedorDAO();
		
		/**Exemplo Pessoa Salva*/
		//Pessoa p = new Pessoa();
		//p.setNome("Lenilton Jr. Coelho");
		//p.setTipoPessoa(TipoPessoa.Fornecedor);
		//p = pdao.save(p);
		//System.out.println(p.getId());
		
		
		/**Exemplo Pessoa Find*/
		//Pessoa p = pdao.get("56fb075dd6abdb0ee05d4943");
		//System.out.println(p.getNome());
		//System.out.println(p.getId());
		
		/**Exemplo Fornecedor Salva*/
		//Fornecedor f = new Fornecedor();
		//f.setCpnj("999999999");
		//Pessoa p = pdao.get("56fb0dc7d6abdb163c98b899");
		//f.setPessoaId(p);
		//f = fdao.save(f);
		//System.out.println(f.getId());
		
		/**Exemplo Fornecedor Find*/
		//Fornecedor f = fdao.get("56fb0df3d6abdb19b88a2538");
		//System.out.println(f.getId());
		//System.out.println(f.getCpnj());
		//System.out.println(f.getPessoaId().getId());
		//System.out.println(f.getPessoaId().getNome());
		
		/**Exemplo Pessoa UPDATE*/
		//Pessoa p = pdao.get("56fb0dc7d6abdb163c98b899");
		//System.out.println(p.getTipoPessoa());
		//p.setTipoPessoa(TipoPessoa.Cliente);
		//pdao.update(p);
		//p = pdao.get("56fb0dc7d6abdb163c98b899");
		//System.out.println(p.getTipoPessoa());
		
		
		
		
		
	}

}
