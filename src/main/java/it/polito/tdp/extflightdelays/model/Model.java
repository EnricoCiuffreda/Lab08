package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	Graph<Airport,DefaultWeightedEdge> grafo;
	private Map<Integer,Airport> idMap;
	private List<Collegamento> collegamenti;
	
	public Model() {
		idMap=new HashMap<>();
	}
	
	public void creaGrafo(long x){
		this.grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		ExtFlightDelaysDAO dao=new ExtFlightDelaysDAO();
		dao.loadAllAirports(idMap);
		Graphs.addAllVertices(grafo, idMap.values());
		collegamenti=dao.collegamentimedia(x,idMap);
		for(Collegamento c:collegamenti) {
		long media=c.getMedia();
		Collegamento tmp = null;
		for(Collegamento c2:collegamenti) {
			if(c.getA1().equals(c2.getA2()) && c.getA2().equals(c.getA1())) {
				tmp=c2;
			}
		}
		if(grafo.containsEdge(c.getA1(), c.getA2())) {
			
		}
		if(collegamenti.contains(tmp)) {
			media=(c.getMedia()*c.getNumerovoli()+tmp.getMedia()*tmp.getNumerovoli())/(c.getNumerovoli()+tmp.getNumerovoli());
		}
		Graphs.addEdge(grafo,c.getA1(),c.getA2(),media);
		}
	}
	
	public int Contavertici(){
		return grafo.vertexSet().size();
	}
	
	public int Contaarchi(){
		return grafo.edgeSet().size();
	}
	
	public String stampa(){
		return grafo.toString();
	}
	
	public String stampaGrafo(){
		String stampa="";
		for(DefaultWeightedEdge a:grafo.edgeSet()) {
			stampa+=grafo.getEdgeSource(a).getId()+"  "+grafo.getEdgeTarget(a).getId()+"   "+grafo.getEdgeWeight(a)+"\n";
		}
		return stampa;
	}

}
