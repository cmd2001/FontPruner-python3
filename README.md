# FontPruner-python3

#### This Project is based on [GameBuildingBlocks/FontPruner](https://github.com/GameBuildingBlocks/FontPruner).

### Changes:

1. Use argparse to parse arguments, instead of docopt.
2. Some grammatical changes from python2 to python3.

### Useage:

1. Install python3 and jre(java runtime environment).

2. Modify `src/FontExtract/unChineseOutPut.txt`, which should contain the characters you want to keep in the new ttf file.

   (The original `unChineseOutPut.txt` contains common symbols and 7613 general Chinese characters.)

3. Execute `python3 ./FontPruner.py [--inputPath INPUTPATH] [--inputFont INPUTFONT] [--tempPath TEMPPATH]`

   For example, `python FontPruner.py --inputPath=./ --inputFont=./XHei-Intel.ttf --tempPath=./`

   The output ttf file will be generated in `output/`

### Orignial readme.md

[FontPruner](https://github.com/GameBuildingBlocks/FontPruner#fontpruner)



