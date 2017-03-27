$(document).ready(function() {

    $.ajax({
        url: "http://localhost:8080/pizzeria-admin-app/api/rest/pizzas"
    }).then(function(data) {
      data=data.sort(function(a,b){
        var cat = "categorie";
        return (a[cat] > b[cat])? 1 : ((a[cat]<b[cat]) ? -1:0);
      });

        var bodylines = data.map(function(pizza) {
            var linePizza = "<tr>" +
                "<td>" + pizza.id + "</td>" +
                "<td>" + pizza.code + "</td>" +
                "<td>" + pizza.nom + "</td>" +
                "<td>" + pizza.prix.toFixed(2) +" €"+ "</td>" +
                "<td>" + "<span class='label label-danger'>"+pizza.categorie+'</span>' + "</td>" +
                "</tr>";
            return linePizza;
        });

        $('.pizzas tbody').html(bodylines);
    });
});
