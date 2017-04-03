$.get("rest/ingredient", function(data){
	
  data.forEach(function(obj){
	  console.log(obj.nom);
	  	  
  });
  
  var items = data.map(function(obj){
	
	  return "<tr><td>"+ obj.code + "</td><td>"+ obj.nom +"</td><td>"+(obj.prix).toFixed(2)+' €'+"</td><td>"+obj.quantite+' pc.'+"</td></tr>";
  });
  
  
  $(".table").html(items);
});

var pizzaTab = [
	{
		nom:"Pépéroni",
		code:"PEP"
	}
]

console.log("pizzaTab =",pizzaTab);

//itérer
pizzaTab.forEach((obj) => {
	//code pour chaque objet
	console.log("Nom =", obj.nom);
});

