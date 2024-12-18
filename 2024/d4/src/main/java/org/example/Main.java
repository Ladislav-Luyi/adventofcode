package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String input = """
MMSSMSMXAMXMSSSSMMXSSMSAMASASXXAAXMAXXAMXAXSXMAMXMMMMSSMXMAAAMXMMMXXAMMAMSAMXXAMMMAAMMMSMMMMMXXSAMXMASXMXSMSXMXMMMSMSAMXSSMMXMMASMSMSMMMAMMS
AASAAAXMSMMAMAXAASMMAAMASXMMSASMSSXASAMXXAXMASAXXMMMAAAXMAMXMSAMSMSSMSMAMMMMSMAMASMMSXMAXXAASXAXAMXMASAMMSAMXMXMAAAXMASXMAMSAXXMSAAAAAASASXS
MXSMMMMAAMAAMXMSMMASMMMAMAAAMAMAAMMAXAMXSSXSAMSMSAMMMSSSMSXMAMAMXMAAXXMMSMAAASAMXSXASMSMSXSMSAMSXMAXASAMAMAMXMASMSXXSAMMSSMSAMSASMMSMSMSASAS
MMMASXSSMXSASXAXASMMAXMMSSMMMXMMMMSSSMSMMAAXXMAXXAMXMMXAAXAXASXMAMSXMSAMXMMSXSXSXMMXMAMXMAMMXAMAMMSMASMMASXMSSXSAMAAMAMMAMXMAAMAMMXXXXXMAMAX
SASXMAAXXMMAMXMMAMXSXMMMXASMMMMXSAAAAAAXMMMMMMXXMAMXMMSMMMSMXAXXXMAASAMXASXMAXXAMXASMSMAMXMASMMXSAAMXMASASAMAMAMAMMXAAMMAMXMMMMMXSAMASMMXMXM
SXSAMXMXMSMAMAMSAMXMXXAASAMXXASAMMSMMXMSMAMAMMASXSSMAAAAAAXMMMMXSMMMSAMMMMAMAMSMSMMSAMMMSSMAMXAXMMMSMSXMASXMASAMAXXAXAXSASAXAXXAAXAMAMAMAMAA
SASXSASAAASMSMMAAMXMSXMMXASXSSMXXAMXSMMXMASMXMXSAAMMMXXSMSXSAASMMSMASAMAAXMMAXXXAAXMXMASAAMAXMMSAMMAAXAMXMMSAXXXSXSAMSMSASXSASMMSSXMASAMAXXX
MAMXSASMSMSMAXMSSMXXMASMSXMASXMSMXSAXAAMMXSXXSMMMMMSMSAMXMASMXMAAXXAMAMSMSXSMSMSSSMSMSXSSSMXSASMASMSMSSMXMAMMSXMXAMXXMASMMAMAXXXAMXXXSXSSSSS
MAMMMAMXAXXMAXXAMXMASAMAASMSMAXXAAMMMMMSMAMXAMAXMMAAAMAMAMAMMSSMMMMSMSMAMSAMAAAXAMXAASAMAXXMAXXMAMXAMAAAMAXXMAXAMXMASMAMMMAMMMSMMSSSXXAXXAAA
SASXMAMSASAMXSMMXSMAMAMXMAXMSAMMMMMSASAMMAMSASXMSSMMMMAMXMSXAXXMASMXAMSSSMAMXMSMSMSMSMAMAMXAXMXMMSSMMSXMASXSSSMXSXXXXMAMXXAXAMXASAAMAMSMMMMM
SXXMMSMMASMMAMASAAMXXMMMXMAMAMXXMAASAXAXMAXAAAAAAAASMSSXSXXMSSMSXSAMMMAXAMXMSAMXAAXMMMAMMSMSASXSXAMXAAMSXXAMAAXAMMMMSSSSMSMSSXSMMMSMAAAXMASX
XMSSXMAMAMAXASAMSSMSXXSAAMXXAXXSXMMMASXMMSSMMMMMSSMMAXMASXMAMAAAXMAMXMASXMAMAMXXMSMAASASXAXMAXXMMMMMMXMXAMAMSMMXSAMAXAAXAAMMMASMXXMXXSSSMASM
MMAMASAMXSXMMMMXXXAMAASMXMMMMAMSAMXMMXMAXAMXXXXXMXAMXMMAMAMMMMAMSXASASASMSSSMMXSAXXSMSMMXSSMSSXSAXAASXMMXXAMMAMXAXSMMMMMMMSAMAMXMASXXMXAMASM
AMASMMMXMXAAXAXXAMAMMMXAXXAAAAASXMASAAMXMMMAMSASMSXMXXMASXMMSMMAMXAMAMAMAMXAAAMMAMAXAMAAAMXMXMAMSMXMSASAASMMMXMAMAXMSAMMSMSASMXXASAMXSXMMASX
MSASAASXSSSMMSSSXXAXMXMMXSSSSSXXMAMAMSMSMXMAXXAAAAXAMXSAMASAAAMSMSMMSMSMSSXSMXSMSMMMMMMMSSMSAMXMMSMAXAMMXMSASASMSMSXXAXSAASAMXSMXMAAMSAMMXSM
MMMSMMSAAMXMXMAMAXSMMXXSAMXAAXXMASXMAMAXMAMMMXSMSMXSAMMXSAMSMSMAAAXSXAXAXMAXSXMAMXXAAAXMXAMSMSMSAAMMMSMXMASMMASAAASASXMSMXMXMAXMAXAMXMAMAMMM
XMAMXAMMMMAMXMAMSMXASMSAMSSMMMAXAMXXAMSMSSSSSMAAXMAXXAAAMMMMXAMMSMSMMMMSMMSMAMMAMMSSSSSXSSMXMXAMMMXAXAAMMAMXMAMMMXMAAAXXMSMXMXSXAMSMSSMMMSAA
MMASMXSMMSASMSAMAAXAMXMAMAAAXSMMSSXMXXAAAAAAXAMSMMMSSMMMMXAXSMMMMMMXAMAXAMMAAAMASXXMAAMAMXMXMMSSXMSSSMXSMXSAMXSSMMSMSXMSMAMAMXXMMMXAXAXSASMS
XSASMSAMXSXAASMSMSMSMSSMMSSMMAAAMMXMSSMSMMMMMSXMASAAAXSSSMMXSAASMMSSXSASAMASMMSASMSMMXMASAMASMASXXAMAXXMAXSASXMMAMXAXXMASMSASASASXSSSMMMASAX
XMSSMAAXMSXMAMXAAAAXAMMSAXAMSSMMXMAXMAXXXMXAMXXSAMMSXMASMAMAXMMMAAAAXMXSXMAMMXMAXAXXMASASASASMAMMMMSAMXMXMSAMMASXMMMMAMAMXSMSAXSAAAAXXAAAMAS
ASAMXMXMAXAXMAXMSMSMXMAMXSAXAAXAASMSSSMMMAASMMMMMSXMAXXXSAMSSMXXXMMMMSMMXMMXSAMXMSMSAMMASXXASMASAAAMASXXMAMAMSMMMXMASXMAMMXAMAMMMMMMMXMAXXXA
MMMSXXAXMMAMXSMAAAAMAMXMASAMXMMSMSAAXAAXMAAAAAAAAXXMSMSMSXXAAXSSSMSXAXAMMSMAMAXXSXAMSSMAMXMAMXXXMXMSXMMMAMMSMSAMXMXXXMSSSMMMMAXAMXMASXSSMSXM
XSXAMMSMSAMSAMMXMMAXAXMSAMXAXXXAXMMMXSAMXSXXXMMMMMSAMAAAXMMSSMMAAAAMSXSAASMMSSMMAMSMAMMMSAMASXMSSSXMMAXAXSAXSXMXAAMMAXAAAXAXMXSMMAMXMXMAAASX
SAMXSAMAMAMSAXAXSSMXMMAMASMSSMSMXMAAAMAMAMASMSMSAAMAMSMMMAAMAXMAMMMSMMMMMMAAAAMSAMAMAMAAXMSASAAAAXAXXXMXXMAMAMXSASAMMMMSMSMMSAXMSMMAAAXMMMAX
SSMAMASMMAMMMMSMMASAAMSMXMXAAAAAAMMMMSAMSXMXAAAMMMMAMAAMSMMSAMMSXXXMXAASXSMMSXMMASAMMSMMSMMAMMMMSMMMSXSXMMSMMXMAXMMXMAXAAMAAMAMXAASMSMSXXXMM
XAMXXAXAMXXXSAXMSAMMXMXAAMMSMSXSMSSXMSMMXAMMMMMMMSSSSMSMAAMMMXXXXSMSSSMSAAXXXMSSMMAMMAMMAXSSSXMAMAXXAAMAMAAAXXMAXMMMXSSMSMMMSAXMAXXAAXAMXSXS
SSMSMSSMMSMMMAXAMXMSMXSSXSAXMXMAXAXAMXMASAMXXAXMXAXMAXAXSXMAMMMSMMAAMXAMMMMMAMAAAMMMSAXSAMXMAAMAXXMXMMSAMSSMMMSAMMAMXMAMXXSASXASMMMSMMXMASAS
MAAAAXAAAAASMSMSMAASXAXXAMMSMXASMSSMMMMMSAMXSMSMMMSASXXXMASXXAAXAMMMMMSMAXAAAMSSMMMAMXMMMSMSSMMSSMXMXXMAMAAXSAMASXSSXSAMMAMASAMXAXXMASXXAMAM
SMMMSSSMSSSMAXAAXSXSMMMSAMAAAXSXAXXXAMAMMMAAMXAXSXSAMXMMMMAASMXMAMXSAAASXSSSXMMMAAMSSSMXXAAMAXXMAXXASAMMMMSASMMXMAAAXSAMXAMXMMXSXMXSMMMMSMAM
XAAXXAAAAMAMXMSMXXMXAXXMASMXSMMMMMSMMMAMAMMSMMSXMXMAXXAAAAAMAAMSSMASMMMSXAAMXMMMMXSAAAASMMSSSMMSAMMMSAMXSSMASAMSMXMMMSAMSMSMXMASMMASAAXAAMAX
SSMSMMMMMMAMXAMMAMMMSAMSXMMXAAXMAAAASXMXMSAAMSMASXSMXMASXSSSMMXAAMXSASXXMMXMAMAAXMAMMMMMAXMMXAXMAMSASAMAMXMSMXMAAXAXAMAMXMAAAMXSAMASXMMSMSSM
XXMAXASXXSASMSSMMMSAAMAXMASXSMMSMXMSMASAAMMMXAXXMXAAAAMMAMAXXMMSSXAMMAXMAXSSMSSXSAAXXXXSXMMASMMAMXMASMMMSAMXAASAMXMMMMMMXSXSMSXSMMXSAXMXMAMA
MMSAMMSAAXAMAMXAAAMASXSXMXMMXMASAXSAXAMMSMAMXASMMSXSMSAMAMMMMMMXMMMMXMAXXSAMXMAAAMASMMXMMMMXMSXXXMMMMXAAXMSMSMSAXXXXMASMMSXXXXXMXSMMMXSSMASX
XMAMXSMXMSSMMMSAMXSSMMMAMMXXAAMMAMSAMXSXAMASMMMAAMMMXMMSXSAMAAAAMASXMXSXMAMMASMAMXSAMXAAAXXAXAXMASAAXSMSMMAAAAMMMSMMSASAASAXASXMASAMXMMXMASA
XSAXXMASXMAAXMAMMAMMAASAMASXSSSMSMMXMASXMMASASMMAMXSAMXMASAMSSSMSAMAXAMAMXMSAXAXXMXMAXSSMSSMSMAMXMASMXXAAMMSMSMAAXXAMSSMMMMMXAAMASAMMASAMAMM
XSAMMMXMASXMMASAMSSSSMSASMSAAAAAMXSAMMMMXMMXAMASAMXMAMAMMMSMXAXXMASMMXMAMAMMMSSMMMMMSMMXMXMMAXMASMXMMMMSSMXXAXMMMSMXMMMXMAAAAMSMASAMASAXSAAX
ASMXMASXXMMMSAMMMAAAXASAMXMAMXMXMASXXAAXMSSMAMXXSXXMASAXXAMMMMMAMAAXSMSMMMSAXXXSXAAAAXXXMASMMMSMMSAAAXXAAMSMAXAXAAMSMXMASMSSMXAMXSAMMXAMMMSM
MXMASMSAMXMAMXSXMMSMXMSMSAMMXMXAMXMASXSSMAXSAMSAMXMSASMSMXSAXMAXXMMAMAAMAAMASXAXSSMMSMXXMASAXAMAASMSMSMXSXAMMMMMMSAAMASMSMAAMXMMASAMXMXSXAAA
XMSMSAMXMAMASMMMAMXXAAMASAMXAAXAAXMXMMAAMAMSXSMXMAXMASXAAXSXSASMSMSAMSMSMXSAMMXMAXMXAMAAMXSASMSMMSAAXAAAMMXAAMXMAXMMSASMXMSSMMXMMMAMMMAMMMMS
MXAAMXMAXXSASAAMMMXSMSXAMAMSASMMMXMMASXSMSXXMSAMXMSMXMXMSMSAMAMAAAXAXAMXMXMAXMMXSAMSAMAXXAMAMMAAMMXMSMSMSASMMSXMASAXMXSXXXAAAMXSMSSMAMASXAMX
ASMMXMXSMAAMSMMXAMAXAXMMMSMMAMMASAASAMAXAMXSAMXSAAXXAMAXMAMXMAMSMSMXXSAMXAXMASAAXAMSAMXAMXMAMSSMMAMXMXMAAMSAAXAMASAMMXSAMMXSMMAXMAAMXXAMMMSA
MXSMAMAXMSMMXMASXSXMAXAAAMAMSXSASXXMAMAMXMASXSASMSMSSSSSMMMAXXMAAAAMSMSMSMXSASMMMSMXMMSXMMMAXMAMSMSASAMXMXSMMSXMAXMMXASMAMXMMMMSMSSMSMSXSAAX
XAXMMMSSXAXXAMASAAMMSSSMXXAMAAMMSMXSAMAMAXXMAMAMSAMXAAASXASMSMXMSMSMAAAXAAAMAXAAAXXMSAMAMAMMSSSMAAXXSMSXXXXXMXMMMSMSMASXSSMMASMXXAMMAAMAMASX
SSSMXAMXXSSSMMAMMMMAMAAXXMSMMXMAXMAXMSMSMSSMAMMMSMSMMMMMSXSAAAMXMAXMMMMMXMSMSSSMSSMXMASMSMSAAAXMMSMASAMXXMASMMMAAAMMAXMAAMXMAMXXMASXMSMMMAMA
AAAXMSSMXXAMAAAXXXMXSSXMAMMAXSMSSMSSXAAAAAMMXMXMXMXMXXXAMSSMMSAMXAMXSMSMSMXAAAAAXXAXSAMMAASMMSMXAAMMSAMXAMXAAASXSMSXXAMMMAASXMSXSASXMAMXMAMX
MMMMAMAMSMAMSSSSSMMAMMAXMASMMSAAAAAXXMSMMSSXSAMSAMASXSMAXAXAMXMXXSXMASAAXSMMMXMMMASXMAXMMAMAAMAMXXXASXMSSSMSSMSXMXMASXXSMMMSAASASASMSASASMSM
XAXXMXAMAAMMAXMAXAMAMSXMSMSMAMMMMMMMAMXASAAAMXMMAMAXAMXSMMSSMSMXXMASMMMXMAMMXMSASXMMXAXSSSSMMSXMXSMMXAXAAAMMXMSASAXXAASXXXAMMMMAMAMXXAMXXMAA
XASASXSSXSMMXSMSXSMSXMAXXXMMSMSXMSXMSSMMSMMMMASMMSSMAMAXAAXAAAAXSSMMXSAAXAMSAMSAAXXXXXXXAAXMXXASASASXMMMSMMSAMMAMXMMSMMMMMMAMXMAMXMXMSMSSSMM
ASMMXAASAMXXAXAMAXXMASXSXSMAMXXASAXMAAAASXMASMXAAAXMAMASMMSMSMXMAAAXMMSXMAXXAXMAMMASMSMMMMMSSMMMAXAMAXXXAMXSAMMSMSXAASAXXASAMMMMMASMMAASASMX
MXAMMSMMXMAXAMXMAMXMAMAXAXMASXSMMMMMSSMMSASASXSMMMSSMSXSAMXAXMAXSMMMAMAMXMMMSMXAXAMAAAMAMXXXAASMSMSMMMSAMXMSXMXXAMMSMSSXXASXXAAASXXASMSMAMXX
XXAMXAAXXASMSMXMMSASXMMMSMSASAAXMXAAXAAMXXMXSAXXAAMAMMAMAMMSMSXMAAAXSMMMXSAAXMSSXSSMSMSSMMSMSMMAAAXSAMXMASXMSMAMAMAMXXAXMXMXSSSXMMXXMMMMXMMS
MSMMSMSAAAXAXMXSAMXSAAXAAMXMMXMXXXMSSMMMMSAAMXMSXXSAMSASAMXMAAMSSMMSMASAAMMMSAXMAMXAAASAAAXAXXMMMSMXXMAMXSMMAMMSAMXSSMMXMAAAMXMAXSSMAXMXMASA
XASMAMXMMAMAMSXMMSMSMMMSSSMSAAMMSXXXAXAASMSSMSMXMXMXMSASMSAMMMMXAMXXXAMMXSXXMXMMMMMMMSSXMSSMMMMAXXMAMMSMXXASMSAMXSMAXASXSMSMSAMAMAASXMSMSMAM
XAASMSAXMAAMXSMSXXXMAMXMAAAMMSAAAMMSMMXSAAAMMAXAAMXSXMXMAMXSAMXMXMSAMXSSMMMMAMXAMAXASAXAXAXXAXXSSMSSXAAMMSMMMMAMAMMASMMAXAAXSXXAXMXSXAAAXAMX
MSMXXSAXSAMMAXAAXMMSAMXMXMMMXMMMMXAAXAXXMMMSSMSMXSAMXMAMSMMSASMMAMXMMMAXAAMMMASMMMMXXASXMASMMSMMAAAMMSMSAAMAASAMASMXSMMMMSMMMMSMSXAXMSMXMSXM
XMXSMMSAMSAMXMSMXSAAXSAMSSXAAXAAAMSMMXSXMAAXAXAAAMAMAXAXAAMSXMMMASASAMXXXXXASMSAASXSMXMASAXXAAAMMSMSAXXXMMXSXXMSXXMAMXAXAXXAXAASAMXMMXSXXMAX
SMAMAAMXAXXMAAAXMMAXMXAXAXAMMSMMXMAASASASMSSSMMMMSSSMSSSSSMMAMXXASASASMSSXSMSAMMAMAAMXSAMXSMSSSMXXXMASMSASAMXSMMXMXAXSXSSSSSSSMSXSMMSAMXMMAM
AMAMMXSMXMASXSSSMSAMSSSMMMMAMAMAMXSAMASAMXMXXAAMMAMXAAAXMXASXMXXMMXMXMAMAASXMXMASMSMMXMXSAXXXAAXXXAMXMAAMMAMAAAAAXMAMMXMAXAXMAMXMXAAMAXSAMXA
MSMSAAXAAMMMMXAAAMXXXAAMXXMASXXXSMMMMMMAMXSAMXSSMSSSMMSMMSXMXAXSSSSSMMMMMMMAXAXMMMAAMXMMMMMSMSMMSSMMSMMMSMSMSMMSXSAMAMXMXMXMSAMAAMMMSAMXSASX
XAXAMMSSMMSAMXMMMMSSMXMMAMMASMSSMMMSAXSXMAMAMAXXMXMASXAAMSAMMSMAAMAAMAASXSSSMSAMXXSXMAMMAAAXXAAAAMAAAAAXMAMAAXXAMXMXMAXMAMAAMASASXAAMXSAXMAX
SXSMSAAAMASASXAXXMXAAXSMMSAMXAXAAAXMAMSMMMSAMSSSXSXMASMSMSAMAXMSMMSMMAXSAAAXSMXMAMAASXMASMSSSSMMMSAMXSMSMAMSSSMXSAAASMMXASXSSXMAXXMSSXSAMXMX
SMXAMMSSMMSAMXMMSASMMMXAASXSSSSMMMSMSAMXXXAMXAAXASMXAMMMXMAMASMMMAXMAMXMAMSMSMMSSSMMSAMAMAMXAXXSXMASMMMMMXXMAMAMSXSXMAXSASAAXAXASMXAXXMXMMXX
SAMSMXMAMAMMMSXAXXXAASMMMSAAAXXAAAXMMAAXMASXMSMMXMAMXMAXMMMMMMAAMXMXSAMXSXMAMMAAAAAXSMMMXAMMMMASASAMAASXMXXMMMMXMMMXMAMMXMMMMSMAXMAMAMAAMXSM
XAMAAAXMMXXMASMSMSMSMSAXAMXMMSSSMSSXSXMXAAMXAAMAXMXMMSXMAASAMXSMSSMMMAMAMAMMMMMSSSMMXAAMXMMAMSASAMASXMMAMMMMXXXAAAAAMAMMAMXXAXMMMSAMAAXMXAAA
AXSXXMSSSSXMXSXMASAAASAMXSAXXXAAAXAXXASMSMSMSMSXXMASXAAMSMSASMXAAXAAXAMMSAMAAXAMXAMMSMMSAMMXMMAXMSAMXSSMMAXMAMSSSMSXSAXSASAMXSASASASXSAAASXM
MXMASMXAAMMMAMAMAMXMMMXMAXMXMMXMSSMASMMAAAMMMMAMMMMSMMXMAAXAMXMMMSMMSSMXSXSSXSASXMMAMXASASXMXMAMASASAMAASMMMMMAMXXAASXMSASXSXSXMASXMAMMMMXAS
XXSAAAMMMMAMAXAMMSMSMSAMSXSASAMXMAAAXAMXMMMAAXAXAASXMAAXMSMSMAAXAMAMXXXXMXMAMMMAMXMAMSMSXMASAMAAMSAMMSSMMSAASMMMSMMMMXXMXMAMAMXMAMMMXMSASMMM
XXMASXSSXSXSSSSSXXAAAMXSAASASXAASXMMSSMASASXMMXSMMMAMSMXAAXAXMMMMSSMMMSAMXAMXSSMAMSSMSAMMSMSASMSXMXMAXASAXMAMASAMASAMXSMMMXMMMAMMMSXMAMASMXA
SMSMMAMXAAMAAAAXAMSMMMMMMXMAMMSXSXSAXXMASASAMSXMMSXXMASMSMSMMSAMMAXAAASAMXAMAXAXSMAMMMMMAAXXAMXXMASMMSAMMSXMMAMXSASMSAAXXASXSSXSAASAMAMSMMSS
AMAAMXMMXMSXMMAMMMXASXMASAMAMMMMXXMASMSMMMMXMAASASMSMAMMAAXXASASXASXMMSAASAMXSSMMMMXAAAMMSSMSMMMXSAAXMMMXMXSMXSMMMSAMXSMMASAAXASMSMXMAMXAAAM
MSSSMAMSMXSXSMXMAAXSAASMSAMAMASAMXSMSAAAASAMXSXMASAXMASMSMXMMSMMMMMMSMXAAMAXXAAASAMMSXSSMXMXXAMAXAXAMMSMSMAXXXXMAAMMMAXXMXMMMMMMMMMSSSSSMMSS
XXMAMASAMXMAMSAMXMSMMXSMSXSXSAMXAMXAMXSSMSXXAMXXAMXMASXAAAXSXMXAAAASAMXMASMMMSMMMASAASAAXAMXMAMSSMMSSMAAAMMSMMMSMMSXMSXXXAXAXAAXAMXAAAXAAAAM
XXMASMSASMMAMAXMAXAXXAMAMAAAMMMXSAMMMAXAXXXMSSSMASASXMMSMSXMASXXMXXXASXMXAAMAMXAXAMMSAXXMASASAMXAXAAAXMSMXAAAAXXXXMMXXASMSXMXMSSXXMMXMXXMMSS
MMAAAASAMXMMSMMMXXSMSMMAMXMMMXAAAXAXMSMMAAMXAAMXXMXMAXAXMAMSXMASMSMMMMAXSSSMAMMSMSSXAMSMSMAXSMXSMMMSSMXAXMMSSMSMAMXXMSMXAMXSAXXMMASAMMXXMAMA
AAMXSAMAMMMAAXAXMAMASXMAXAXAXMASMSSMXMAXXAAAMSMSMSASAMSSSMAXASAMXAAASMSMMMXMASAAAAAAMXAASXMASAMAXXAAAMXMSSMAXAAXSAMXMAAMSMAMAMMASMMASAASMSSS
SXSAMXSXMAMSMMASXXMAMAMSSSSMSXMXAAAXASXMAMXXSAAAAMAMAMAAMSAMXMASXMSMSAAMAAAXXMXMSAMMXMMSMAXAXMAAMMMSASXMAMMMMSMMMSAAMASMAMMMAXMAMASAMXMSAXAX
MSMXSMMMMSAMXMMAMXMMMSAAAAXMAMAMMMMMMSSSXSAXXMSMSMXMAMMSMXMAMSSMMAMAMXMMASMSAMXXAASXXMSAXXMMXXMSMXMMAMXMASXMAXASAAMMXMMXXSSMMSMASAMASMMMXMAM
XXXMXMAAAXXMASMAXAXXAMMMSMMMAXMASAMMXSAXAMASMXXAXMSSSSXXMASXXXAAXSMAMAXXMMMXMXMASAMMAMMAXSASAMXAAAXMMMXMASAMMSAMXSXSAAXAMAAAAMXAMXXMMXAAMMXM
SMXMAMMXSXAMAXSSSMXMXSMXAXAMXXXMXMMMMMAMAMAMAAMAMAAAXXXXSAMXMMMMMMSASASXXAMXMAXXMAAMSMMSMMASASMMSMSMAMSMMXMMMMMXXXASXSSMMSSMMMMXSXSXXSAMSSXM
ASXSAMMMXMMMAXXMAMAMMMMMMMSMSXSSXMASASMMSAXSXMXAMMMMMSMXMASXSASAAASXSAMXSMSASXSXXSMXMAAAAMAMMMMAAXAXASAMXSAMXAMMSMAMAAAAAXXXSXSMSASAAXXSXMAS
MSMMMXXAXAXAXSASAMMXAAMAXAMASAMXXSASASAXXAAMAMSASXSAAAAAXXAASASXSMMAMAMXAXSMMAAMXMMASMMSXMSMMAMMMSASMSMXMASMMAXAXMAMSSSMMSAASXXAMAMMMMMAASMM
XXAXAAMXMMMMMSAMXSXSSSSSMAMAMXMAAMAMMMMSAMXMAMXAMASMSMSSSXMXMAMXMAMMSSMMMMSXMSMMAXSASAMMMAMXMAXAMMMSXMXMAXMXSAMSMSXMAAXMSMMMXAMMMXMAAAMMAMXS
MMSMMXSAAXAXXMMMMAMAAAAMMXMAMXMASMMMAXXAXMXMAXMAMXMXXXAAMXMAMXMASAMXAXAASAMXXMASXXMASXAAMAMASXSXSAAMMMAMMAMAAAXAASXSMMMMAXASXXMAAASXSXSXMMAS
SAAXMAMXSMMMSAMMAAMMMMMMAXXAMSAMXMASMSXASAXAAXSXMSMASAMAMAMASAMMSAMXASXMMMSMXMMMMMMMMMSXMAXXMXAASMMSASAXSAMXMSAMXMASXXMSMSSXMASXMXMXMASXSMAS
MSSSMMSMXMMMXAMXSXSAMXXMAMMAMXAXXXXAXMMMXMSMMMMAMAMMSASAXSSMMASXXXMMAAMSXMSXSAAAMSSMMMMASAMSAMMMMAMXXMAMSMMSXXMXSMMMAXMAMXXAXXMASMSMSASASMMM
MAMXXMAMMSXSSMMXMXSMSMMMAMSSMSSMMMSSXMASMXSASASASASMSAMAXXAMXSAMXAXSMSXSAASAMSSMSAAAAAMXMAMSAMSASAMSSSXXXAAXMASAMAXSSMSMSMSMMMMMAAAMAAMXXAAA
SAMMMSAMXAAXMSMAMAMXSAASAMXXAXAAAXAXASXSAMXASASASASAMAMXMSAMMAAXSMMXAXASMMMSMAMXMMSMMSSXSMMMAMXASXSAMXMASMMSMSMMXSMMXAXAAAAMAMAXMMASMXMSMMMS
AAAAMMMMMMSMAAMAXXSAMMMMAXXMMMSXMXAXMMMXMAMXMMMMMMMAMXMXXMMMSSMMXSAMXMXMXSAAMAMSXMXXAXXXXMSXSMMXMMMMXAAAXAMSMXASAXAXMAMSMSASASXSSMASXSSMXSMM
XSMXSASAMXAMMMSXSAMXSAMSSMMAMAMASMSMSASXMSXSAAXAAXXXSXMSXAAAMAMMXMSSXMASAMXXMAXAMXMSMXMMMMMAMAMAXAASMSMXSMXMASAMASMMAXMXAMMMASAAXMAMMSAAASXS
XXMMSASXMSASXAAMMMMAXXXAAXASMASXMXAASAMAAMASXMSMSXSMXAAAXSMXXAMSAAAMASAMASASMSSMAAAAMAAAAAMXMASMSSMXAXMAMXAMMMSMMMMXSSMMXSSMAMMMMMMSXSMMMSAM
XSAMMAMAXSAMXMMSAMMMSMMSSMSMMMSMSXMMMSMMMMAMAMSMMAAASMMMXMXSSSMSMSSSMMASAMASAMXXXMSASXSSSMSAXXMAMAAMSMSMSXXXXAMXSAXAMAASAMXMMXAXAAASXMASAMMM
MSAMXAMXMMAMMMASXSASAAMXXMXSAMXASAXXAAXXXMASAMXASAMXAMXXAXAMAXAMAAXXXSAMMMXMMMMSXAMXXAMAMASMSMMASMMMMAAAMMSMMXMASXMSXSXMASAMSSSSSSXSASAMAMXS
ASAMSSSXSSSMAMXXXSMSMSSMSMMSXSMXXSMMSSXMMSMSMXMXMAXXMXSSMMSMAMMMMMSSMMMMXSAAMMAAMSMSMSMAMXMAAAXASAMXMMMXMAAAASMMSXAXAMMSXMASAAAMAXASAMXSMMAM
MXAMXXMAAAAMXXASAMXSMAMASAMMXMXMSMMMAMXAXXAXXSAMXXMMMMMAMAMXSSMASXAXXAMXASXSMSAMAMAMAXMAMSSSXSAASXXXAXMAMSSSMSAAMMMMAMASAMXMMSMSSMMMSMMXMMXX
MSSMMMMMMMMSMMSAMMASMASMSAMXAXAXAAXMASXSMMMMMAAASXSXSASAMXSMXAMASMSMSASMMMAXAXXXAMAMMMSMSAAMAMMXMASMMASXXAAAASXMMAAMSMMSAMAMAMXAXXXAAXXXMMMS
XAMAMAAAAXSAAXMASMXMXASXSMMSMSMSMMMMXMAMXAAMMMMSXASAMXSASMSAMMMXMXXAMAXMSMAMSMMSMSXSAAAXMMMMAMXASXMASAXMMSSMXMASXSXSAAXSAMXMASMMXAMSSSMXMAAA
MXSASXSXXXSMMMSAMMAMMXSAXMAAMAAAAASXMMAMSSMMAASAMXMAMAXXXMMXASAMMSMXMXMXAMMSMAXMASASMMSSMXXMAXSASASMSAMXXAMXAMMMAMMXXXMSAMSSMSAXAXAMMAAASMSM
AASXSMXXSXMSSMMSMMAXSXSASMSSSMXMSMSAMSSXMAAMXMMAMMSAMMSMXSMSMMASXAAXMAMMMSMAXAMXAMAMAAXMAXMMAMMAMAMXMMXMSASMXMAMAMMSMSAMXMASMSMSXSSSMMSMSAMX
MMSASASMSAAXXXAAXMAMSAMAMXAXMAMXMASAMAMASMMMSASAMASXXMAMAMXAAXAMMMXASMXXAAXAMXSXSMSXMMMSASXSSMMSMMMSXMAMMAMASMSSMMAAASXSSSMSXXXSAMAMMAXMXAXM
SXMXMAMASMMMXMASAXXAMAMMMMMSMMAAMASMMAMXMAAMAXXASXMAMSXMASXSSMMSAXMMAXAASMMMSAXXXAMSMSMAAXAAASAXASAXASXSMSMAMXMAMMMMMXAMAAXMMSMMMMAMMMMMMAMA
MASXMMMAMAAAXAMMASMMSXMXAASAAMSXMASAMASMSSMSMSSMMMSAMMASAXXAAAXXXMXMAMXMAAAAMMSAMXMAXAMMMMMSMMXSAMXXMMMMAAMXSXSAMXSMSMXMMMMXAAAAMMXSAAAMXMAS
SAMAAXMAXMMSAMAAAXAXAMSSMSSMSMXAMXMXMAXXAMAMXMAAMASAXSAMMSSSMMMSSMSMSAXXSMMSAMXXXAXMSMSAAXXMAXAMMXSSMAXMMMSAMAMMSXMAAAASMMXMSSSMSSMSXSSMASMX
MASMMMSSMXAAMXAMMSMMMSAAXAMMXASXMAMMASMMXMAMASMMMASAMMMXXAAAMXMXAAAAMSMXMXAAXSAMXXXXAXXXSSXSAMXSMAMASMSSMXSAMSMAMAMSMSASXAMMMMAAAXAXXXAXAXMX
SAMMXXMAASAMXMXAMAMAXMXXMMSMMXMXMMSMAMSAAXASAMMSMXXAXASXMSXXMSASMMMSMXXAMMSMSMXSAXSSMSXAXAMXMSMAMSSXMMAASMSXMAMASMMXAMAMXSAAAMMMMXSMMSSMMSSS
MASMXSMXMMAAMSSXSASMMXSMMMAAMXXAMAMMSMMXMXAMMSMAXSSMMMXAAMASAMAMMAMXXXMMXAXXMMAMMXXAASAMMAMAMAMXXAMASMSMMMMMMSSMXXSMMMSMAMSSSSMXSMXAXAAAAAMA
SMMMAMAMXSXMSMMASASMMAMAASMSMMSMSAMXMSMASMSMAAXXSMAXSMSMMMMXAAAMMSMSXMASAMSAAMAMXMMMMMAXSAMASMSMMASXMAXAMXSAAMAMXSMSMAAMAMMXMAMAMXSMMSMMMSSM
XAAMXMAAMMMMAAMAMXMAMMSSMSAMAAAXSXMSMMMAMAAMSSSMMXXMAMSXMAXSAMXSXXASASAMXXSMMSMMSAMSXSSMSXSASXAXSXMASASAMMMMXXAMSAAAMSXSMMSASXMMXAMXAMMSAMAX
SSMSMSMXAAAMSSMMMAMAMXAXSMAMMMSXMAMMASMSSSXXXMXAXXXSXXMASMMMSMASXMMMAMXXSAMXXAMAAMAMAMAAXMMXMMAXAMSAMAXAMAXMSSSMMMSMXMASAASASXAASXMMMSMMASMX
XAAXAAXXSSXMAAASXXMASMMXAMAMXMMAXMMMXMAMAMXXMASMMXMXMMXXMSAXAMASASXMXMXAMXSXSASMMXXMAMMSMXSAMXMSMMMSMMSMSMSAXXMAXXAXAMAMMMMAMMMMXXAAMAXSAMXM
XMAMSMMMMAXMXSMMASMMMXXXSMMSXSSSMSSSSMXMAMXSAMXAXAXAMXXMASXSXSXSAMXMAMMMAASXMAMMXMAXASXMAXMASAXAAXAXXXAMAAMMMMSXMXMAMMXMXXSAMXSAMSSMSMMMXXAX
MXMAAASMMMMXAXAMAMAAMMSMMASMMAAAASAXXAASAMAAAMSSXMSMXSAMAMMSAXMMXMXSAXAXMMSASAMMASMSMSAMMXMAMXSSSMMSXSASMMXAAAMXMMXMXMMSSMMAXMMAXMAASXASMSSS
ASXMMSMAAMXMASAMXMMAMAAAXXMAXMMMMMMMMSMSASMSSMAXAAAXXAAMXSAMAMAMSMMMSSSSMXSAMMXMASXAAXAMXSMXSAMXXAXSAXAMXXSSMSMAMAXXAMASAMSSMAXMMSMMMSASAAAA
SXMASAMSMMAXXXAMXASXMSMSMMSSMXXXAAXAXXXXAMXAXMASMMMSSSMMXMXXXAMXAAAAXMMAMAMAMAAMMMMSMSMMXMAAMAMXSSMMAMSMSAMXAXXMXAXSMSMSAMAMASXXAAAXXMMMMMMM
ASMMSAMXMSXSMMAMXMSAAXAXAXAMXAXSSSSSSXMMSMMMXMASAMAMMAASXMSMXSSSSSMXSMSSMXSAMMXXAAXXMAXMXSXMXAMXMAAMAMAAXXXMXMASMMMXAAASXMXMXXAMMXMMXMASXXXA
MXMASMMAMSAAAASMSSMMMMAMXMAXAMAMXAAXMAMAAAAXXMXSAMXMMSMMAMAXMXAAMXMAAMAAAMAMMXASMSMMSMSMAAAXSSMMXSMMMSMMMMXMXSMXASASXMMMSMASXXMAXAASAMXSXAXA
MMSASMSXMMMMXMXAXAXMXMXMASXMSSXMMMMMSSMSSMMMMMMXMXXSAXMSSSMSXMMMMAMSXMMSMMAMMMMAAAXAAAAMMMSAXAAMXXAXAMAMASXMASXMXMAMSAAAXMAMAAXAXSSMASAMXSMM
XAMXSMMXSAMXSXMXMMMSXMAMXMMXAAXSAMXMAAAXMAXXASMAMXMMASXXAAXMASXMMXXAASXXXSXSXXXMSMSSMSMSMAXMSSMMASAMXMXSAXAMAMMXSMSMSXMSSMMSSMMSXXAXAMAAAMAM
MSSSMXSASMSAAAAXMXXAAMMSSSMMMSXMASAMSMMMSAMASXMASASMMMMMMMXMMXAXMMMSSMASAMAXMAMXXXMMAAMXMMSMMMAMASXMMSMMASMMSSSMAAAAXASXAAAAAAAXXSAMXSXMXSAM
SAMAAAMAMXMMSXSASAMMSXAAAAAMXMMMAXXMAMXXMASXMASMSASAXASMSMASMSMMSAMXAMAMAMAMMXMAMAXMSMXSAMXXAXMMMXASXAAMAMXAAAAXMMMMMMMAXMMSSMMSMMAMXSAMXMMM
MASMMMMAMAXMAAMXSASAAXMMSSMMXXAMMSMSMSMXMASAMMAMMMMMSXSAASASMAMASASXSMXMASXSMAAASAMXMXASXXXSXMMASMMMSMSMMSSSMSMMXAXSASXSMMXMXAAAASAMXXAAASAS
SAMXMXSXSASMMSMASMMASXXAXAAMASAMXAMMXMXASAMXAAAMASAAMXMMMMSSMXMAXMAMXASMAXMAMXSMSXAASMMSMMXMAXSAXSAAAXAAXXAMAAAAXSXSASAAXXAAXMMSMMASMMMMASAS
SAMXMASAMXSASMMMSXSMMMSSSSMMAAXXSSMSASMMMMSMSSXSASMSMSXMXMASXSMMSAMXSASMSMSMMXMASXSASMXMASXSAXMXMAXSXMXSMMMMXMASMXAMAMMMMMXSASAXASXMAAMAMMMM
XXAAMMSAMASXMAAASMMAAXMAAMAMMXMMMMAMASXXAMSAAXMMMSMXAMAMXMASXSAAXAMAMAMAAXAASXMASXMAXMASXMAMXSXSSSMMXSAMMAXXXXAXAMXMXMMMSXAXAMXSMSAMSSSMMAXA
MSSSXXXAMXSMSMMXSAMSSSMMMMSMMAAAAMAMSMMSMSMMMSXMASXMMSAMAMMSXMAMXXMXMMMXMSMMMAMASXMMMMMMSMXMAXAMAXXAASASXSSMXMAXMXMXMAAASXMMXMASASMMXAXXXXMM
AAAMMMSAMXMMAMSAMMMAMXXSXMXASXSSXMAXXAAXSAMAMSAMXSAMXAAMAXMXMMAMXSXMSAMXMAMASXMASAAAAAAAMMSSSMAMMMMMMXAMAAXAMSMSMAXMASMMSAXAXMXMAMXSMSMSXSSS
SMMMAXSMMMSAMXMAXSMASMAMMSMMMAAAAASASMMSMMSAXMXMASAMXMMMXXSAXMAMXAAASAMXSXSAMAMAXXSXSSMSSMAAASXMXAAASMSMMMMXMAAAMXMAXXSASAMMSMAMAMSAAMAMAXAM
AXXMSMMAAXXMXMSMMASMXMAAMXAXMMMSMAXASAMXAASMMSXSASXMMMSSSMMASMXMMMSXSAMAMXMASXMMSMXAMXXAXMMSMMXXSMSASAAASXSASMSMMSASXAMXXXMAAXASASXMMMAMMMSM
MMSXMAMSASXMAXAAAMXXXMXSAXSMXXAMXMMSMXMSMMXAASMSASAMAXAAAMMMMASXSXXAMXSAMASMMXAXXAXAXXMASMXAAXAXSAAMMXMMMAXAXAAAXXAMMSMSSSSXSSMSXSAMXSXSAAXM
SMSASAMMAMXSASXSMXMMSMAAMSMMAMAMAXMXMAMMASXMMSAMAMAMSMMSMMAAMAMAXXMXMAMASASMAXXSSMSSMMXAMAMSXMXXMAMMMMSAMSMSMSMXMSMMAMAAAAAAXMASAXMAXAASMMSS
SASAMASMAMXMASMMMAMAAMAMXAXMAAMSSMMXSAXMAMMXMMMMXSMMXAAMXSXMMAMXMSMMMMSAMAMMSXMAAAAXAMMSSMAXASXXSSMSXASMSXAXMAMSMMMAXMMMSMMAMXAMSMMSSMAMAAMA
MAMAMXSXMMMMMMMASAMSSSSXSMSSMSAAXAXASXSMXSAAXMXMAXAXSMMMASAMSASMSAAAAMMXMAMMMAMMMMMXAMXAAXMSAMAAAAAXMMSXMMSMXMMMAAAAXSXAMXSXMAXMAMXAAXXMMMSM
MSMXAAMAMXAXMAXXXAXMMAMMMXMAAAMMSMMXSAMAMAMMSXSMMSMMASMMAMAMXMMMMXSMSMSASXSAMAMXXAXMSSSSSMAMAMXMSMMMMXSAMAMAXSASXMMMASMMSASAASXSASMSMMMXSAMX
SMMSSMXAMMAMMMMSSSMAMAMASAMXMMMAAASAMAMAMMXXMASXMAMXMAXSAMMMSMMMSMXXMASAMXMXMSMMSXSAAAXMAMXSSMMMXAAXSASAMXXXXMASAAXSAXAAAASXMAASAMXAAXAAXASM
AAXAAASMXSASASXAAXSXMAXAXASMSMMSSXMASXMASAMMMMMAXAMMXMMXASXAAAAMAASAMAMAXSMSXAAXAAXMMMMSXMAXAAXXSSMSMASAMXXMAMXSMSAMXSMMMMMASMXMAMXSMMMMSAMX
MSMMSMXAASASASMMMMAMSSSMSAMAMXXMAMXAMXSXMMMAAMMAMMSAMXXSXMMSSSMSMSMMMSMAMSAMXSMMMSMMXXMXAMXMSXMAMAMXMAMAAAASXMAMXXMXMMMMXMSXMMMMMMAMMSAAMAMX
XAAXMXMMMMAMXMAAXXXAAXAMAMMSMSMMAXMASXSMSSSSSSMAXSAXAAXMXSXAAMMSXXAMAXMXSMASAMXSXXASMSSSMMSMMMSMSAMMMMSXMSMSAMXSAMXAAAAAAXMAMXAAMMXSAMXSMSMA
SMSXSASAMXMMMSSMXSAMSSXMAMXAAAMMAMSMMASAAMMAXAMXXSAMMSSMASMMXMASXXAMXSXMXMAMAXAXMSAMAMAAMAAMMAXASMSAAAAXAAASAMASAASXSSMXAMSSMSSSXAAMXMXMAMAA
SXMAMXSAMAMAXAAMASXMAAASAXSMSMSMAMAAMAMMMSSSSSXSAMXMXAMMAMAXAMXSMSMMASAMASMSXMMSMMAMSMSMMSSSMMMXMAXXAMXMSMXMMMMSAMXAXAMSSMAMAMAMXMMSAMAMAMAX
XAMAMXMXSASXSSXMASAXMSMSAMSAAAXXSSSSMAXAAMMAAXAASXAXMASMASMSSSXMAAAMASMMAXXAXAAAAAXMAMAAXAAXAASAMXMMXAXXXSAMXAASMMMSMMMAAMAMAMAMXAAXMSMSXSMX
SXMASMAMSAMXMASMMSAMXAMXMASMMXMAMMXXXXSMSSMMMMXMASXSXSXMMSXXMAMMSXSAMXMMASMXMMSSSMSSXSSSMMSSSMSMSAXXMASXMASXSMMSXSXAASMMSSMSXSXSXMSMMAMXMAMS                                                                                                                                  MXMXAXMASX
            """;
    static String searchFor = "XMAS";
    static List<List<Character>> listList = parseInput(input);
    static Set<String> wordList =  prepareWordList(searchFor);

    public static void main(String[] args) {
//        part1();
        part2();
    }

    private static void part2() {
        show(listList);
        long totalCount = 0;
        for (int i = 0, listListSize = listList.size(); i < listListSize; i++) {
            List<Character> outer = listList.get(i);
            for (int j = 0, outerSize = outer.size(); j < outerSize; j++) {
                if (!listList.get(i).get(j).equals('A')){
                    continue;
                }
                try{
                    if (
                            isPair(i, j, 'M', 'M', 'S', 'S') ||
                            isPair(i, j, 'S', 'S','M', 'M') ||
                            isPair(i, j, 'S', 'M','S', 'M') ||
                            isPair(i, j, 'M', 'S','M', 'S')
                    ){
                        totalCount++;
                    }
                }catch (IndexOutOfBoundsException e){
                }

            }
        }
        System.out.println(totalCount);
    }

    private static boolean isPair(int i, int j, char ...c) {
        return listList.get(i - 1).get(j - 1).equals(c[0]) &&
               listList.get(i + 1).get(j - 1).equals(c[1]) &&
               listList.get(i - 1).get(j + 1).equals(c[2]) &&
               listList.get(i + 1).get(j + 1).equals(c[3]);
    }

    private static void part1() {
        show(listList);
        long totalCount = 0;
        for (int i = 0, listListSize = listList.size(); i < listListSize; i++) {
            List<Character> outer = listList.get(i);
            for (int j = 0, outerSize = outer.size(); j < outerSize; j++) {
                List<String> wordFromRange = createWordFromRange(i, j, searchFor.length());
                long count = wordFromRange.stream().filter(wordList::contains).count();
                totalCount += count;
            }
        }
        System.out.println(totalCount);
    }

    private static List<String> createWordFromRange(int i, int j, int n) {
        ArrayList<String> r = new ArrayList<>();
        for (Directions value : Directions.values()) {
            createWordFromRange(value, i, j,0, n, new StringBuilder(), r);
        }
        return r;
    }

    private static void createWordFromRange(Directions direction,
                                            int i,
                                            int j,
                                            int steps,
                                            int n,
                                            StringBuilder stringBuilder,
                                            List<String> result) {
        if (steps == n){
            result.add(stringBuilder.toString());
            return;
        }

        try {
            stringBuilder.append(listList.get(i).get(j));
        } catch (IndexOutOfBoundsException e){
            return;
        }

        if (direction.equals(Directions.RIGHT)) {
            createWordFromRange(direction, i, j + 1, steps + 1, n, stringBuilder, result);
        } else if (direction.equals(Directions.DIAGONAL_DOWN_RIGHT)) {
            createWordFromRange(direction, i + 1, j + 1, steps + 1, n, stringBuilder, result);
        }else if (direction.equals(Directions.DOWN)) {
            createWordFromRange(direction, i + 1, j, steps + 1, n, stringBuilder, result);
        }else if (direction.equals(Directions.DIAGONAL_DOWN_LEFT)) {
            createWordFromRange(direction, i + 1, j - 1, steps + 1, n, stringBuilder, result);
        }else if (direction.equals(Directions.LEFT)) {
            createWordFromRange(direction, i, j - 1, steps + 1, n, stringBuilder, result);
        }else if (direction.equals(Directions.DIAGONAL_UP_LEFT)) {
            createWordFromRange(direction, i - 1, j - 1, steps + 1, n, stringBuilder, result);
        }else if (direction.equals(Directions.UP)) {
            createWordFromRange(direction, i - 1, j, steps + 1, n, stringBuilder, result);
        }else if (direction.equals(Directions.DIAGONAL_UP_RIGHT)) {
            createWordFromRange(direction, i - 1, j + 1, steps + 1, n, stringBuilder, result);
        }
    }

    private static Set<String> prepareWordList(String s) {
        Set<String> wordList = new HashSet<>();
        wordList.add(searchFor);
//        wordList.add(new StringBuffer(searchFor).reverse().toString());
        return wordList;
    }

    private static List<List<Character>> parseInput(String input) {
        List<List<Character>> listList = new ArrayList<>();
        for (String s : input.split("\n")) {
            ArrayList<Character> inner = new ArrayList<>();
            for (String string : s.split("")) {
                inner.add(string.charAt(0) );
            }
            listList.add(inner);
        }
        return listList;
    }

    static void show(List<List<Character>> listList){
        for (List<Character> list : listList) {
            for (Character c : list) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }

    enum Directions{

        RIGHT,
        DIAGONAL_DOWN_RIGHT,
        DOWN,
        DIAGONAL_DOWN_LEFT,
        LEFT,
        DIAGONAL_UP_LEFT,
        UP,
        DIAGONAL_UP_RIGHT
    }

}