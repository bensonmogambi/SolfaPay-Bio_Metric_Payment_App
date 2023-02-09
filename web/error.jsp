<%-- 
    Document   : error
    Created on : Apr 23, 2015, 11:05:03 PM
    Author     : arjunmehrotra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=2">
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
        <link rel="stylesheet" href="appcss.css" type = "text/css"/>
        <script type="text/javascript" language="javascript" src="jQuery.js"> </script>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    </head>
    <body>
        <div data-role="page">
                <div data-role="header" data-theme="b" data-position="fixed">
                    <h1>PayBM</h1>
                    <a href="index.jsp" data-icon="back" class="ui-btn-Left" rel="external">Back</a>
                </div><!-- /header -->

                <div role="main" class="ui-content ui-grid-b" data-theme="b" >

                    <div class="ui-grid-b ui-responsive">
                        <div class="ui-block-a">	
                           
                        </div>
                        <div class="ui-block-b">
                            <div data-role="collapsible" data-collapsed-icon="carat-d" data-expanded-icon="carat-u" data-content-theme="b" data-collapsed="false">
                            <h4>Error</h4>
                            <ul data-role="listview" data-inset="false">
                                <li><a href="index.jsp" rel="external" ><%=request.getAttribute("ErrorMessage")%></a></li>
                            </ul>
                        </div>
                             
                        </div>
                        <div class="ui-block-c">
                            
                        </div>
                        <div class="ui-block-a">

                        </div>
                        <div class="ui-block-b">
                        </div>
                    </div>
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
    </body>
</html>
