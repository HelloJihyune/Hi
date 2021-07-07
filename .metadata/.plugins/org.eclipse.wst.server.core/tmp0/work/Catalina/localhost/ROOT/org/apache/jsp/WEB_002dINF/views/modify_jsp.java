/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.48
 * Generated at: 2021-07-06 02:38:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class modify_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/modify.css\">\r\n");
      out.write("<title>회원정보 수정</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<header>\r\n");
      out.write("		<div class=\"text-area\">\r\n");
      out.write("			<h1>나의 정보 수정</h1>\r\n");
      out.write("		</div>\r\n");
      out.write("	</header>\r\n");
      out.write("	<section class=\"modify-form\">\r\n");
      out.write("		<!--비밀번호-->\r\n");
      out.write("		<div class=\"int-pass\">\r\n");
      out.write("			*비밀번호<br> <input id=\"pw\" type=\"password\" name=\"pw\"\r\n");
      out.write("				placeholder=\"비밀번호\" label for=\"pw\"> </label>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"int-pass\">\r\n");
      out.write("			* 비밀번호 재확인<br> <input type=\"password\" name=\"user_PW2\"\r\n");
      out.write("				placeholder=\"비밀번호 재확인\">\r\n");
      out.write("		</div>\r\n");
      out.write("		<!--닉네임 수정-->\r\n");
      out.write("		<div class=\"int-username\">\r\n");
      out.write("			* 닉네임<br> <input type=\"text\" name=\"user_name\" value=\"\">\r\n");
      out.write("		</div>\r\n");
      out.write("		<br>\r\n");
      out.write("		<!--생년월일 select를 사용해서 구현-->\r\n");
      out.write("		* 생년월일<br>\r\n");
      out.write("		<br> <select name=\"year\">\r\n");
      out.write("			<option value=\"\">-- 선택 --</option>\r\n");
      out.write("			<option value=\"1994\">1994</option>\r\n");
      out.write("			<option value=\"1995\">1995</option>\r\n");
      out.write("			<option value=\"1996\">1996</option>\r\n");
      out.write("			<option value=\"1997\">1997</option>\r\n");
      out.write("			<option value=\"1998\">1998</option>\r\n");
      out.write("			<option value=\"1999\">1999</option>\r\n");
      out.write("			<option value=\"2000\">2000</option>\r\n");
      out.write("		</select> <select name=\"month\">\r\n");
      out.write("			<option value=\"\">-- 선택 --</option>\r\n");
      out.write("			<option value=\"1\">1</option>\r\n");
      out.write("			<option value=\"2\">2</option>\r\n");
      out.write("			<option value=\"3\">3</option>\r\n");
      out.write("			<option value=\"4\">4</option>\r\n");
      out.write("			<option value=\"5\">5</option>\r\n");
      out.write("			<option value=\"6\">6</option>\r\n");
      out.write("			<option value=\"7\">7</option>\r\n");
      out.write("			<option value=\"8\">8</option>\r\n");
      out.write("			<option value=\"9\">9</option>\r\n");
      out.write("			<option value=\"10\">10</option>\r\n");
      out.write("			<option value=\"11\">11</option>\r\n");
      out.write("			<option value=\"12\">12</option>\r\n");
      out.write("		</select> <select name=\"day\">\r\n");
      out.write("			<option value=\"\">-- 선택 --</option>\r\n");
      out.write("			<option value=\"1\">1</option>\r\n");
      out.write("			<option value=\"2\">2</option>\r\n");
      out.write("			<option value=\"3\">3</option>\r\n");
      out.write("			<option value=\"4\">4</option>\r\n");
      out.write("			<option value=\"5\">5</option>\r\n");
      out.write("			<option value=\"6\">6</option>\r\n");
      out.write("			<option value=\"7\">7</option>\r\n");
      out.write("			<option value=\"8\">8</option>\r\n");
      out.write("			<option value=\"9\">9</option>\r\n");
      out.write("			<option value=\"10\">10</option>\r\n");
      out.write("			<option value=\"11\">11</option>\r\n");
      out.write("			<option value=\"12\">12</option>\r\n");
      out.write("			<option value=\"13\">13</option>\r\n");
      out.write("			<option value=\"14\">14</option>\r\n");
      out.write("			<option value=\"15\">15</option>\r\n");
      out.write("			<option value=\"16\">16</option>\r\n");
      out.write("			<option value=\"17\">17</option>\r\n");
      out.write("			<option value=\"18\">18</option>\r\n");
      out.write("			<option value=\"19\">19</option>\r\n");
      out.write("			<option value=\"20\">20</option>\r\n");
      out.write("			<option value=\"21\">21</option>\r\n");
      out.write("			<option value=\"22\">22</option>\r\n");
      out.write("			<option value=\"23\">23</option>\r\n");
      out.write("			<option value=\"24\">24</option>\r\n");
      out.write("			<option value=\"25\">25</option>\r\n");
      out.write("			<option value=\"26\">26</option>\r\n");
      out.write("			<option value=\"27\">27</option>\r\n");
      out.write("			<option value=\"28\">28</option>\r\n");
      out.write("			<option value=\"29\">29</option>\r\n");
      out.write("			<option value=\"30\">30</option>\r\n");
      out.write("			<option value=\"31\">31</option>\r\n");
      out.write("		</select> <br>\r\n");
      out.write("		<br>\r\n");
      out.write("		<div>\r\n");
      out.write("		<!--이메일-->\r\n");
      out.write("		* 이메일\r\n");
      out.write("		<div class=\"fieldlabel\">\r\n");
      out.write("			<label for=\"email01\"></label>\r\n");
      out.write("			<div class=\"formfield\">\r\n");
      out.write("				<input type=\"text\" id=\"email01\" name=\"email01\" size=\"20\"\r\n");
      out.write("					maxlength=\"20\" value=\"\" autocomplete=\"off\"><span>@</span> <input\r\n");
      out.write("					id=\"email02\" name=\"email02\" list=\"domains\">\r\n");
      out.write("				<datalist id=\"domains\">\r\n");
      out.write("					<option value=\"naver.com\">\r\n");
      out.write("					<option value=\"daum.net\">\r\n");
      out.write("					<option value=\"gmail.com\">\r\n");
      out.write("					<option value=\"yahoo.co.kr\">\r\n");
      out.write("				</datalist>\r\n");
      out.write("			</div>\r\n");
      out.write("			<br>\r\n");
      out.write("	</section>\r\n");
      out.write("	<!--로그인 회원가입 버튼-->\r\n");
      out.write("	<input type=\"submit\" value=\"정보수정\">\r\n");
      out.write("	<input type=\"submit\" value=\"취소\">\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
