<%-- 
    Document   : manageCard
    Created on : Apr 24, 2015, 9:46:57 PM
    Author     : arjunmehrotra
--%>

<%@page import="org.w3c.dom.Document"%>
<%@page import="javax.smartcardio.Card"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="MDT.FingerPrint.cmu.CreditCard"%>
<%@page import="MDT.FingerPrint.cmu.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
        <link rel="stylesheet" href="http://cdn.rawgit.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.css">
        <link rel="stylesheet" href="appcss.css" type = "text/css"/>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        <script src="http://cdn.rawgit.com/jquery/jquery-ui/1.10.4/ui/jquery.ui.datepicker.js"></script>
        <script id="mobile-datepicker" src="http://cdn.rawgit.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.js"></script>
        <title>PayBM</title>
    </head>
    <body>

        <div data-role="page" class="ui-responsive-panel">
            <div data-role="header" data-theme="b" data-position="fixed">
                <h1>PayBM</h1>
                <a href="#nav-panel" data-icon="info" class="ui-btn-Left">Options</a>
                <a href="#popupDialog" data-icon="power" data-rel="popup" data-position-to="window" data-transition="pop" class="ui-btn-Right">Logout</a>
            </div><!-- /header -->

            <div data-role="popup" id="popupDialog" data-overlay-theme="b" data-theme="b" data-dismissible="false" style="max-width:400px;">
                <div data-role="header" data-theme="a">
                    <h1>Delete Page?</h1>
                </div>
                <div role="main" class="ui-content">
                    <h3 class="ui-title">Are you sure you want to Logout?</h3>
                    <a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" data-rel="back">Cancel</a>
                    <a href="index.jsp" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" rel="external">Logout</a>
                </div>
            </div>

            <div role="main" class="ui-content ui-grid-b" data-theme="b" >
                <%  Boolean cardFlag = false;
                    Customer cust = (Customer) request.getAttribute("customer");
                    ArrayList<CreditCard> card = (ArrayList<CreditCard>) request.getAttribute("creditcard");
                    if (card.size() > 0) {
                        cardFlag = true;
                    }else{
                        card = null;
                        String url = "jdbc:oracle:thin:@localhost:1521:xe";
                         Connection conn = DriverManager.getConnection(url, "CASTEEL", "tiger");
                                            
                         Statement statement = conn.createStatement();
                         String queryString = "select * from creditcard where UserName='cust.getUsername()'";

                         ResultSet rs = statement.executeQuery(queryString);
                         rs = statement.executeQuery(queryString);                   
                         while (rs.next()) {
                             CreditCard card1 = new  CreditCard();
                             cardFlag = true;
                             card1.setCardHolderName(rs.getString("CARDHOLDERNAME"));
                             card1.setCreditCardNumber(rs.getString("CREDITCARDNUMBER"));
                             card1.setCvv(rs.getString("CVV"));
                             card1.setExpiry(rs.getString("EXPIRYDATE"));
                             card1.setIsPrimary(rs.getString("ISPRIMARY"));
                             card.add(card1);
                         }
                    }                  
                %>
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
                    <!--<div id="cards">-->
                    <div class="ui-block-a">
                        <div class="ui-corner-all custom-corners">
                            <div class="ui-bar ui-bar-b">
                                <h3>Credit Card Details</h3>
                            </div>
                            <div class="ui-body ui-body-a">
                                <% if (cardFlag == true) {%>
                                <table data-role="table" id="transaction-table" data-mode="columntoggle" class="ui-responsive table-stroke">
                                    <thead>
                                        <tr>
                                            <th data-priority="1">Id</th>
                                            <th>Card Number</th>
                                            <th data-priority="1">Card Holder Name</th>
                                            <th data-priority="1">CVV Number</th>
                                            <th data-priority="1">Expiry Date</th>
                                            <th data-priority="1">Is Primary</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (int i = 0; i < card.size(); i++) {%>
                                        <tr>
                                            <th><%=i + 1%></th>
                                            <td><%= card.get(i).getCreditCardNumber()%></td>
                                            <td><%= card.get(i).getCardHolderName()%></td>
                                            <td><%= card.get(i).getCvv()%></td>
                                            <td><%= card.get(i).getExpiry()%></td>
                                            <td><%= card.get(i).getIsPrimary()%></td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                                <% } else { %>
                                <p> No Primary Card available</p>
                                <%}%>
                            </div>
                        </div>
                    </div>


                    <div class="ui-block-b">
                        <div class="ui-corner-all custom-corners">
                            <div class="ui-bar ui-bar-b">
                                <h3>Add Card</h3>
                            </div>
                            <div class="ui-body ui-body-a">
                                <form type="input" action="AddCardServlet" method="Get">
                                    <input type="hidden" name="username" value="<%=cust.getUsername()%>" id="username">
                                    <div data-role="fieldcontain">
                                        <label for="cardNum">Credit Card:</label>
                                        <input type="text" name="cardNum" id="cardNum">
                                    </div>
                                    <div data-role="fieldcontain">
                                        <label for="cardName">Credit Card Name:</label>
                                        <input type="text" name="cardName" id="cardName">
                                    </div>
                                    <div data-role="fieldcontain">
                                        <label for="cardCvv">Credit Card CVV:</label>
                                        <input type="text" name="cardCvv" id="cardCvv">
                                    </div>

                                    <div data-role="fieldcontain">
                                        <label for="cardExp">Credit Card Expiry:</label>
                                        <input data-role="date" type="text" name="cardExp" id="cardExp">
                                    </div>

                                    <div data-role="fieldcontain">
                                        <label for="isPrimary">Credit Card Primary:</label>
                                        <select name="isPrimary" id="isPrimary" data-role="slider" data-theme="b">
                                            <option value="N">No</option>
                                            <option value="Y">Yes</option>
                                        </select> 
                                    </div>
                                    <button name="addCard" id="Add Card">add</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!--</div>-->
                </div>
            </div>

            <div data-role="panel" data-position-fixed="true" data-display="overlay" data-theme="b" id="nav-panel">
                <ul data-role="listview">
                    <li data-icon="delete"><a href="#" data-rel="close">Close menu</a></li>
                    <li><a href="LoginServlet?username=<%=cust.getUsername()%>&password=<%=cust.getPassword()%>" rel="external">Home</a></li>
                    <li><a href="EditProfileServlet?username=<%=cust.getUsername()%>" rel="external">Edit Profile</a></li>
                    <li><a href="ManageCardServlet?username=<%=cust.getUsername()%>">Manage Cards</a></li>
                    <li><a href="ViewTransactionServlet?username=<%=cust.getUsername()%>">View Transactions</a></li>
                    <li><a href="Register1Servlet?username=<%=cust.getUsername()%>">Register Fingerprint</a></li>
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
</html>
