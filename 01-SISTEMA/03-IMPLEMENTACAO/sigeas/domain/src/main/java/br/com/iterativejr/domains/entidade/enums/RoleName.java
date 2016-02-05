package br.com.iterativejr.domains.entidade.enums;

/**
 * <p>
 * <b> Enum com as funcoes </b>
 * </p>

 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */
public enum RoleName {

	/**
	 * Pagina do Estudante
	 */
    ROLE_STUDENT("/pages/student/index-student.html"), 
    /**
	 * Pagina da assistente social
	 */
    ROLE_SOCIAL_WORKER("/pages/socialWorker/index-social-worker.html"),
    /**
     * Pagina do setor financeiro
     */
    ROLE_FINANCIAL_WORKER("/pages/financialWorker/index-financial-worker.html");

    /**
     * Pagina que eh Direcionada
     */
    private String redirectPage;

    /**
     * Construtor com a pagina direcionada
     * @param redirectPage pagina direcionada
     */
    private RoleName(String redirectPage) {
        this.redirectPage = redirectPage;
    }

    /**
     * Pega Pagina direcionada
     * @return retorna pagina
     */
    public String getRedirectPage() {
        return redirectPage;
    }

}
