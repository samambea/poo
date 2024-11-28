package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InterfaceCommand {
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
