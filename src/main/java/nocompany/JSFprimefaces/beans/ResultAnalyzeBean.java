package nocompany.JSFprimefaces.beans;

import nocompany.JSFprimefaces.entity.TagA;
import nocompany.JSFprimefaces.utils.ParserHTML;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;


@ManagedBean(name = "resultAnalyze")
@ViewScoped
public class ResultAnalyzeBean {

    private String url;
    private List<TagA> tagAList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<TagA> getTagAList() {
        return tagAList;
    }

    public void setTagAList(List<TagA> tagAList) {
        this.tagAList = tagAList;
    }

    public void findAllNodes() {
        try {
            tagAList = ParserHTML.parse(url);
        } catch (Exception e) {
            throwError();
        }
    }

    public void removeList() {
        tagAList = null;
    }

    public void throwError() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_ERROR, "Error", "Проверьте правильность адреса"));
    }
}
