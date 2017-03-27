$(document).ready(function() {

    $.ajax({
        url: "http://localhost:8080/pizzeria-admin-app/api/rest/pizzas"
    }).then(function(data) {

        var bodylines = data.map(function(pizza) {
            var linePizza = "<tr>" +
                "<td>" + pizza.id + "</td>" +
                "<td>" + pizza.code + "</td>" +
                "<td>" + pizza.nom + "</td>" +
                "<td>" + pizza.prix +" €"+ "</td>" +
                "<td>" + pizza.categorie + "</td>" +
                "</tr>";
            return linePizza;
        });

        $('.pizzas tbody').html(bodylines);
    });
});
