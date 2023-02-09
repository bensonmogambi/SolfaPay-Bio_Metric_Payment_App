<%-- 
    Document   : fingerScan1
    Created on : Apr 25, 2015, 4:19:23 AM
    Author     : arjunmehrotra
--%>

<%@page import="MDT.FingerPrint.cmu.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=2" HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
        <link rel="stylesheet" href="appcss.css" type = "text/css"/>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        <title>PayBM</title>
    </head>
    <body>
        <div data-role="page" id="main" class="ui-responsive-panel">
             <% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>
            <div data-role="header" data-theme="b" data-position="fixed">
                <h1>PayBM</h1>
                <a href="#panel" data-icon="info" class="ui-btn-Left">Options</a>
                <a href="#popup" data-icon="power" data-rel="popup" data-position-to="window" data-transition="pop" class="ui-btn-Right">Logout</a>
            </div><!-- /header -->

            <div data-role="popup" id="popup" data-overlay-theme="b" data-theme="b" data-dismissible="false" style="max-width:400px;">
                <div data-role="header" data-theme="a">
                    <h1>Delete Page?</h1>
                </div>
                <div role="main" class="ui-content">
                    <%  Customer cust = (Customer) request.getAttribute("customer");%>
                    <h3 class="ui-title">Are you sure you want to Logout?</h3>
                    <a href="LoginServlet?username=<%=cust.getUsername()%>&password=<%=cust.getPassword()%>" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" data-rel="back">Cancel</a>
                    <a href="index.jsp" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" rel="external">Logout</a>
                </div>
            </div>

            <div role="main" class="ui-content ui-grid-b" data-theme="b" >
                <div class="ui-grid-a ui-responsive">
                    <div class="ui-block-a">	
                        <div class="ui-corner-all custom-corners">
                            <div class="ui-bar ui-bar-b">
                                <h3>User Profile</h3>
                            </div>
                            <div class="ui-field-contain">
                                <label for="firstname">First Name:</label>
                                <input disabled="disabled" name="firstName" id="textinput-disabled" value="<%=cust.getFirstName()%>" type="text">
                                <label for="lastname">Last Name:</label>
                                <input disabled="disabled" name="lastName" id="textinput-disabled" value="<%=cust.getLastName()%>" type="text">
                                <label for="username">User Name:</label>
                                <input disabled="disabled" name="username" id="textinput-disabled" value="<%=cust.getUsername()%>" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="ui-block-b">
                        <div class="ui-corner-all custom-corners">
                            <div class="ui-bar ui-bar-b">
                                <h3>User Profile</h3>
                            </div>
                            <div class="ui-field-contain">
                                <label for="dob">DoB.:</label>
                                <input disabled="disabled" name="dob" id="textinput-disabled" value="04-04-1988" type="text">
                                <label for="phonenumber">Phone No.:</label>
                                <input disabled="disabled" name="phonenumber" id="textinput-disabled" value="<%=cust.getPhoneNumber()%>" type="text">
                                <label for="address">Address:</label>
                                <input disabled="disabled" name="address" id="textinput-disabled" value="<%=cust.getAddress()%>" type="text">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ui-grid-solo">
                    <div class="ui-corner-all custom-corners">
                        <form type="input" action="Register2Servlet" method="Get">
                            <input type="hidden" name="username" value="<%=cust.getUsername()%>" id="username">
                            <div class="ui-bar ui-bar-b">
                                <h3>Scan Image</h3>
                            </div>
                            <div class="ui-body ui-body-a">
                                <img src="<%=cust.getUsername()%>.png" alt="image" style="position: relative; top: 50%; left: 50%; ">
                                <button name="scanImage" id="scanImage" style="position: relative; top: 50%; ">Scan Image</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div data-role="panel" data-position-fixed="true" data-display="overlay" data-theme="b" id="panel">
                <ul data-role="listview">
                    <li data-icon="delete"><a href="#" data-rel="close">Close menu</a></li>
                    <li><a href="LoginServlet?username=<%=cust.getUsername()%>&password=<%=cust.getPassword()%>" rel="external">Home</a></li>
                    <li><a href="EditProfileServlet?username=<%=cust.getUsername()%>" rel="external">Edit Profile</a></li>
                    <li><a href="ManageCardServlet?username=<%=cust.getUsername()%>">Manage Cards</a></li>
                    <li><a href="ViewTransactionServlet?username=<%=cust.getUsername()%>">View Transactions</a></li>
                </ul>
            </div><!-- /panel -->
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
</body>
</html>
