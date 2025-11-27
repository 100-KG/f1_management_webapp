<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    List<GPinSeason> gpList = (List<GPinSeason>) session.getAttribute("currentGP");
    List<Result> results = (List<Result>) session.getAttribute("ResultList");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8">
        <title>Update Result</title>
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/UpdateResult.css">
    </head>
    <body>
        <div class="container">

        <h2>Update Result</h2>

        <form method="post" action="../doupdate">
            <select name="selectedGP" class="gp-dropdown">
                <option disabled selected>Select Grand Prix</option>
                <% if(gpList != null) {
                    for(GPinSeason g : gpList) { %>
                        <option value="<%=g.getId()%>">GP <%=g.getGrandPrixId()%></option>
                <% }} %>
            </select>

            <!-- RESULT TABLE -->
            <table class="result-table">
                <tr>
                    <th>Driver</th>
                    <th>Team</th>
                    <th>Point</th>
                    <th>Time</th>
                    <th>Laps</th>
                </tr>

                <% if(results != null){
                    for(int i=0; i<results.size(); i++){ Result r = results.get(i); %>
                        <tr>
                            <td><%= r.getDriverName() %></td>
                            <td><%= r.getTeamName() %></td>

                            <!-- Editable -->
                            <td><input type="number" name="point_<%=i%>" value="<%=r.getPoint()%>"></td>
                            <td><input type="text" name="time_<%=i%>" value="<%=r.getTime()%>"></td>
                            <td><input type="number" name="laps_<%=i%>" value="<%=r.getLapfinished()%>"></td>

                            <input type="hidden" name="rid_<%=i%>" value="<%=r.getId()%>">  
                        </tr>
                <% }} %>
            </table>

            <div class="actions">
                <button type="submit" name="action" value="save" class="btn-save">Save</button>
                <a href="StaffHome.jsp" class="btn-back">Back</a>
            </div>

        </form>

    </div>
    <body>
</html>
