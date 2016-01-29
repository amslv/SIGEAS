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

    ROLE_STUDENT("/pages/student/index-student.html"), ROLE_SOCIAL_WORKER("/pages/socialWorker/index-social-worker.html"), ROLE_FINANCIAL_WORKER("/pages/financialWorker/index-financial-worker.html");

    private String redirectPage;

    private RoleName(String redirectPage) {
        this.redirectPage = redirectPage;
    }

    public String getRedirectPage() {
        return redirectPage;
    }

}
