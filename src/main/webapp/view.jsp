<%@ page import="java.util.*,model.Patient" %>

    <% List<Patient> list =
        (List<Patient>)request.getAttribute("patients");

            %>

            <html>

            <head>

                <title>Patients List</title>

                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

            </head>

            <body class="bg-light">

                <div class="container mt-5">

                    <div class="card shadow p-4">

                        <h2 class="text-primary mb-4">

                            Patients List

                        </h2>

                        <table class="table table-bordered table-striped">

                            <tr class="table-dark">

                                <th>ID</th>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Disease</th>
                                <th>Edit</th>
                                <th>Delete</th>

                            </tr>

                            <% for(Patient p : list){ %>

                                <tr>

                                    <td>
                                        <%= p.patientId %>
                                    </td>

                                    <td>
                                        <%= p.name %>
                                    </td>

                                    <td>
                                        <%= p.age %>
                                    </td>

                                    <td>
                                        <%= p.disease %>
                                    </td>

                                    <td>

                                        <a href="edit.jsp?id=<%= p.patientId %>" class="btn btn-warning btn-sm">

                                            Edit

                                        </a>

                                    </td>

                                    <td>

                                        <a href="delete?id=<%= p.patientId %>" class="btn btn-danger btn-sm">

                                            Delete

                                        </a>

                                    </td>

                                </tr>

                                <% } %>

                        </table>

                        <a href="index.jsp" class="btn btn-primary">

                            Add New Patient

                        </a>

                    </div>

                </div>

            </body>

            </html>