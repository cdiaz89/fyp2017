package com.rcgd.fyp.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoBounds;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;
import org.jxmapviewer.viewer.util.GeoUtil;

public class MainView extends JFrame {
	
	JXMapViewer mapPanel;
	JPanel controlPanel;
	JPanel mainPanel;
	
	
	public MainView() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		controlPanel = new JPanel();
		JButton button1 = new JButton();
		controlPanel.add(button1);
		
		mapPanel = new JXMapViewer();
		// Create a TileFactoryInfo for OpenStreetMap
		TileFactoryInfo info = new OSMTileFactoryInfo();
		DefaultTileFactory tileFactory = new DefaultTileFactory(info);
		mapPanel.setTileFactory(tileFactory);
				
		// Use 8 threads in parallel to load the tiles
		tileFactory.setThreadPoolSize(8);

		// Set the focus
		GeoPosition frankfurt = new GeoPosition(51.5387199, -0.1166466);
		mapPanel.setZoom(7);
		mapPanel.setAddressLocation(frankfurt);
		
		mainPanel.add(mapPanel, BorderLayout.CENTER);
		mainPanel.add(controlPanel, BorderLayout.NORTH);
		
		this.getContentPane().add(mainPanel);
		this.setSize(800, 600);
		this.setVisible(true);
		
		Point2D pt = new Point2D.Double(mapPanel.getViewportBounds().getX(), mapPanel.getViewportBounds().getY());
		GeoPosition topLeft = mapPanel.getTileFactory().pixelToGeo(pt, mapPanel.getZoom());
        
		GeoPosition x = new GeoPosition((frankfurt.getLatitude() + topLeft.getLatitude())/2, 
				(frankfurt.getLongitude() + topLeft.getLongitude())/2);
        
        Set<Waypoint> waypoints = new HashSet<Waypoint>(Arrays.asList(
        		new DefaultWaypoint(topLeft),
        		new DefaultWaypoint(frankfurt),
        		new DefaultWaypoint(x)));
        
     // Create a waypoint painter that takes all the waypoints
     		WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
     		waypointPainter.setWaypoints(waypoints);
     		
     		List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
    		painters.add(waypointPainter);
    		
    		CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
    		mapPanel.setOverlayPainter(painter);
    		System.out.println(topLeft.toString());
    		System.out.println(mapPanel.getViewportBounds().getX());
    		System.out.println(mapPanel.getViewportBounds().getY());
    		System.out.println(mapPanel.getViewportBounds().getWidth());

	}

}
