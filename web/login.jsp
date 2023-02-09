<%-- 
    Document   : login
    Created on : Apr 27, 2015, 3:40:13 AM
    Author     : arjunmehrotra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=2" CONTENT="no-cache">
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
        <link rel="stylesheet" href="http://cdn.rawgit.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.css">
        <link rel="stylesheet" href="appcss.css" type = "text/css"/>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        <script src="http://cdn.rawgit.com/jquery/jquery-ui/1.10.4/ui/jquery.ui.datepicker.js"></script>
        <script id="mobile-datepicker" src="http://cdn.rawgit.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <form type ="input" action="LoginServlet" method="Get">
            <div data-role="page">
                <div data-role="header" data-theme="b" data-position="fixed">
                    <a href="index.jsp" data-icon="back" class="ui-btn-Left">Back</a>
                    <h1>PayBM</h1>
                </div><!-- /header -->

                <div role="main" class="ui-content ui-grid-b" data-theme="b" data-ajax="false" >

                    <div class="ui-grid-b ui-responsive">
                        <div class="ui-block-a">

                        </div>
                        <div class="ui-block-b">

                        </div>
                        <div class="ui-block-c">

                        </div>
                        <div class="ui-block-a">

                        </div>
                        <div class="ui-block-b">
                            <p>
                                <br><br><br><br><br><br><br><br>
                            </p>
                            <input name="username" id="username" value="" type="text" placeholder="User Name" data-mini="true">
                            <input name="password" id="password" value="" type="password" placeholder="Password" data-mini="true">

                            <%--<a href="LoginServlet" class="ui-btn ui-btn-b ui-btn-inline" data-theme="b" data-mini="true" id="login" name="login">Login</a>--%>
                            <input type="submit" value="Login">
                            <a href="register.jsp" class="ui-btn ui-btn-a" data-theme="b" data-mini="true" rel="external">Register</a>
                        </div>
                        <div class="ui-block-c">

                        </div>
                    </div>
                    <div class="ui-block-b">

                    </div>
                    <div data-role="footer" data-position="fixed" data-theme="b">
                        <div data-role="navbar">
                            <ul>
                                <li><a href="#" data-icon="comment">About</a></li>
                                <li><a href="#" data-icon="mail">Help</a></li>
                                <li><a href="#" data-icon="user">Careers</a></li>
                                <li><a href="#" data-icon="info">Terms & Conditions</a></li>
                            </ul>
                        </div>
                    </div><!-- /footer -->
                </div>
        </form>
    </body>
</html>
