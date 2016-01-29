package br.com.iterativejr.service.negocio.enums;

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

    ROLE_STUDENT("/pages/student/index-student.xhtml"), ROLE_SOCIAL_WORKER("/pages/socialWorker/index-social-worker.xhtml"), ROLE_FINANCIAL_WORKER("/pages/financilWorker/index-financial-worker.xhtml");

    private String redirectPage;

    private RoleName(String redirectPage) {
        this.redirectPage = redirectPage;
    }

    public String getRedirectPage() {
        return redirectPage;
    }

}
