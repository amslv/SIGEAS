package br.com.iterativejr.domains.entidade.enums;

/**
 * <p>
 * <b> Título </b>
 * </p>
 *
 * <p>
 * Descrição
 * </p>
 * 
 * <pre>
 * @see <a href="http://www.linkreferencia.com">Link de Referencia</a>
 * </pre>
 * 
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */
public enum RoleName {

	/**
	 * endereços
	 */
    ROLE_STUDENT("/pages/student/index-student.html"), ROLE_SOCIAL_WORKER("/pages/socialWorker/index-social-worker.html"), ROLE_FINANCIAL_WORKER("/pages/financialWorker/index-financial-worker.html");

    /**
     * page
     */
    private String redirectPage;

    /**
     * construtor
     * @param redirectPage
     */
    private RoleName(String redirectPage) {
        this.redirectPage = redirectPage;
    }

    /**
     * pega endereço
     * @return
     */
    public String getRedirectPage() {
        return redirectPage;
    }

}
