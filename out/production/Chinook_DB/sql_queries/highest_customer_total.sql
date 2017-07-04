SELECT MAX("Sum"."Highest_Total") FROM (SELECT SUM("Total") AS "Highest_Total" FROM "Invoice" GROUP BY "CustomerId") AS "Sum";

select "CustomerId", sum("Total") as "sum" 
from "Invoice" 
group by "CustomerId" 
having sum("Total") = (SELECT MAX("Sum"."Highest_Total") 
						FROM (SELECT SUM("Total") 
								AS "Highest_Total" 
								FROM "Invoice" 
								GROUP BY "CustomerId") 
						AS "Sum");
						
select "CustomerId", sum("Total") from "Invoice" group by "CustomerId" order by 2
desc limit 1;