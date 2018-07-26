package core.mvc;

import javax.jws.WebParam;

public abstract class AbstracrtController implements Controller{
    protected ModelAndView jspView(String forwardUrl){
        return new ModelAndView(new JspView(forwardUrl));
    }
    protected ModelAndView jsonView(){
        return new ModelAndView(new JsonView());
    }
}
