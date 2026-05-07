<%@ page import="java.sql.*" %>
<%@ page import="util.DBConnection" %>

<%

int id = Integer.parseInt(
        request.getParameter("id")
);

Connection con =
        DBConnection.getConnection();

PreparedStatement ps =
        con.prepareStatement(
                "SELECT * FROM patients WHERE id=?"
        );

ps.setInt(1, id);

ResultSet rs = ps.executeQuery();

rs.next();

%>

<html>

<body>

<h2>Edit Patient</h2>

<form action="update" method="post">

    <input type="hidden"
           name="id"
           value="<%= rs.getInt("id") %>">

    Name:

    <input type="text"
           name="name"
           value="<%= rs.getString("name") %>">

    <br><br>

    Age:

    <input type="number"
           name="age"
           value="<%= rs.getInt("age") %>">

    <br><br>

    Disease:

    <input type="text"
           name="disease"
           value="<%= rs.getString("disease") %>">

    <br><br>

    <button type="submit">

        Update Patient

    </button>

</form>

</body>

</html>