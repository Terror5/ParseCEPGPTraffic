Parse CEPGP Traffic


Parses the traffic sectiom of a CEPGP.lua file into a CSV file.
(tested and working for CEPGP-1.13.1-Release, see https://www.curseforge.com/wow/addons/cepgp)

Usage:
 1. Adjust String path = "C:\\Users\\xxx\\Desktop\\Raid\\" in Main class to your folder
 2. Copy CEPGP.lua from "World of Warcraft\ \_classic\_\WTF\Account\ <Your-Account-here>\SavedVariables" to this folder
 3. Run Main

Converts: 

		{
			"Kherac", -- [1]
			"Krusell", -- [2]
			"Add GP 28 (Full Price)", -- [3]
			282, -- [4]
			282, -- [5]
			144, -- [6]
			172, -- [7]
			"|cffa335ee|Hitem:20928:::::::::::::|h[Befehlsbindungen der Qiraji]|h|r", -- [8]
			1600988523, -- [9]
			1601034328.264, -- [10]
			"Player-4440-010C88BF", -- [11]
		}, -- [350]
		
To:
Kherac,Krusell,Add GP 28 (Full Price),172,172,100,128,|cffa335ee|Hitem:20928:::::::::::::|h[Befehlsbindungen der Qiraji]|h|r,10.09.2020 23:42:09,11.09.2020 05:58:23,Player-4440-010C88BF,

For Usage in GoogleDocs/Excel.
