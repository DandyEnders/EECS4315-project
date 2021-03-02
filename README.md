# EECS4315-project

## Report link
https://docs.google.com/document/d/1uvYb5NFN8ni4_SVkQAkdtxQE0CuQ0BcO5KOgz58fDC8/edit?usp=sharing


## How to run this project
1. clone the project
```bash
git clone https://github.com/DandyEnders/EECS4315-project/
```
2. In Eclipse, File -> Import -> General -> Existing Projects into Workspace -> select root directory -> Browse -> <repository directory>
3. Now you can go `/src/ctl/CTL.g4` and save it (ctrl + s) to generate java files in `target/genereated-sources/antlr4/ctl/*`.


## How to test CTL formulas
1. In Eclipse, Help -> Eclipse MarketPlace -> Find `ANTLR 4 IDE`
2. Install `ANTLR 4 IDE`
3. Restart Eclipse
4. In Eclipse, Window -> Show View -> Other -> ANTLR 4 -> Parse Tree AND Syntax Diagram
5. Open `/src/ctl/CTL.g4`
6. Save with Ctrl + S 
7. Double click "root" token in `CTL.g4` file
8. In Parse Tree view, you may now write formulas to test it.
