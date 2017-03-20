# goeuro-busroute

Station Nodes are in the form of parent child relationship, where the relationship is established based on the bus route they are on and if they are connected.

Given a depart station id, this application checks for any bus route where this station id is present.
There can be multiple bus routes, for each bus route, arrival station id is searched on the same bus route. The first bus route where we find the arrival station id
as directly connected, we return it as true.
