package spaceExplorer;

public class PlanetInfo {
	public int CurrentPlanetIndex = 0;
	static Planet[] PlanetList = new Planet[9];
	
	public Planet TravelToNewPlanet() {
		CurrentPlanetIndex ++;
		return PlanetList[CurrentPlanetIndex % 9];
		
	}
	
	public Planet CurrentPlanet() {
		return PlanetList[CurrentPlanetIndex % 9];
	}


}
