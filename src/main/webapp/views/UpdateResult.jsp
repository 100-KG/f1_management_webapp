<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.f1management.model.GPinSeason" %>
<%@ page import="com.f1management.model.Result" %>

<%
    GPinSeason[] gpList = (GPinSeason[]) session.getAttribute("currentGP");
    Result[] results = (Result[]) session.getAttribute("currentResult");
    String message = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Result</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="css/styleUpdateResult.css">
</head>

<body>
<div class="container">

    <h2>Update Result</h2>

    <% System.out.println("UpdateResult.jsp loaded"); %>

    <% if(message != null) { %>
        <p class="alert"><%= message %></p>
    <% } %>

    <form method="post" action="doupdate">
        <label>Select a Grand Prix</label>
        <select name="selectedGP" class="gp-dropdown" onchange="this.form.submit()">
            <option disabled selected>-- Select Grand Prix --</option>
            <% if(gpList != null){
                for(GPinSeason gp : gpList){
            %>
                <option value="<%= gp.getId() %>"
                <%= (session.getAttribute("selectedGP")!=null && session.getAttribute("selectedGP").toString().equals(gp.getId()+"")) ? "selected" : "" %> >
                <%= gp.getCountry() %> GP
                </option>
            <% }} %>
        </select>
    </form>

    <form method="post" action="doupdate">
    <table class="result-table">
        <tr>
            <th>Driver</th>
            <th>Team</th>
            <th>Point</th>
            <th>Time</th>
            <th>Laps</th>
            <th>Position</th>
        </tr>

        <% if(results == null) { %>
    <% for(int i=0;i<20;i++){ %>
        <tr>
            <td>—</td>
            <td>—</td>
            <td><input type="number" name="point_<%=i%>" value=""></td>
            <td><input type="text"   name="time_<%=i%>" value=""></td>
            <td><input type="number" name="laps_<%=i%>" value=""></td>
            <td><input type="number" name="pos_<%=i%>" value=""></td>
        </tr>
    <% } %>

<% } else { %>

    <% for(int i=0;i<results.length;i++){ Result r = results[i]; %>
        <tr>
            <td><%= r.getDriver() %></td>
            <td><%= r.getTeam() %></td>

            <td><input type="number" name="point_<%=i%>" value="<%=r.getPoint()%>"></td>
            <td><input type="text" name="time_<%=i%>" value="<%=r.getTime()%>"></td>
            <td><input type="number" name="laps_<%=i%>" value="<%=r.getLapFinished()%>"></td>
            <td><input type="number" name="pos_<%=i%>" value="<%=r.getPosition()%>"></td>

            <input type="hidden" name="rid_<%=i%>" value="<%=r.getId()%>">
        </tr>
    <% } %>

<% } %>

    </table>

    <div class="actions">
        <button type="submit" name="action" value="save" class="btn-save">💾 Save Update</button>
        <a href="views/StaffHome.jsp" class="btn-back">⬅ Back</a>
    </div>
    </form>

</div>
</body>
</html>
