<%-- 
    Document   : index
    Created on : Apr 27, 2015, 12:04:37 AM
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
        <div data-role="page">
            <div data-role="header" data-theme="b" data-position="fixed">
                <h1>PayBM Demo</h1>
            </div><!-- /header -->

            <div role="main" class="ui-content ui-grid-b" data-theme="b" data-ajax="false" >
                <div class="ui-grid-solo">
                    <img src="logo.png" alt="image" style="position: relative;  left: 40%;">
                </div>
                <div class="ui-grid-b">
                    <div class="ui-block-a">

                    </div>
                    <div class="ui-block-b">
                    
                    </div>
                    <div class="ui-block-c">

                    </div>

                    <div class="ui-block-a">

                    </div>
                    <div class="ui-block-b">
                        <a href="vendorShop.jsp" class="ui-btn ui-btn-b" data-theme="b" data-mini="true" rel="external">Vendor Application</a>
                        <a href="login.jsp" class="ui-btn ui-btn-b" data-theme="b" data-mini="true" rel="external">User Application</a>
                    </div>
                    <div class="ui-block-c">

                    </div>
                </div>
                <div data-role="footer" data-position="fixed" data-theme="b">
                    <div data-role="footer" data-position="fixed" data-theme="b">
                    <div data-role="navbar">
                        <ul>
                            <li><a href="#" data-icon="comment">About</a></li>
                            <li><a href="#" data-icon="mail">Help</a></li>
                            <li><a href="#" data-icon="user">Careers</a></li>
                            <li><a href="#" data-icon="info">Terms & Conditions</a></li>
                        </ul>
                    </div>
                </div>
            </div>
    </body>
</html>
