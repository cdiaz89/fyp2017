package com.rcgd.fyp.main.java.gui.sample;

import javax.swing.JFrame;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.w3c.dom.*;

import com.rcgd.fyp.gui.view.MainView;

import javax.xml.parsers.DocumentBuilder;

public class GUISample {
	public static void main(String[] args)
	{
		/*JXMapViewer mapViewer = new JXMapViewer();

		// Create a TileFactoryInfo for OpenStreetMap
		TileFactoryInfo info = new OSMTileFactoryInfo();
		DefaultTileFactory tileFactory = new DefaultTileFactory(info);
		mapViewer.setTileFactory(tileFactory);
		
		// Use 8 threads in parallel to load the tiles
		tileFactory.setThreadPoolSize(1);

		// Set the focus
		GeoPosition frankfurt = new GeoPosition(51.5387199, -0.1166466);

		mapViewer.setZoom(7);
		mapViewer.setAddressLocation(frankfurt);
		
		// Display the viewer in a JFrame
		JFrame frame = new JFrame("TAE KA SHIT");
		frame.getContentPane().add(mapViewer);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		*/
		
		new MainView();
	}

}
