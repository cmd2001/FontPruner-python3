// Copyright 2012 Google Inc. All Rights Reserved.

package com.google.typography.font.sfntly.table.opentype;

import com.google.typography.font.sfntly.Tag;

import java.util.Arrays;
import java.util.List;

/**
 * @author dougfelt@google.com (Doug Felt)
 */
enum LanguageTag {
  ABA("Abaza", "abq"),
  ABK("Abkhazian", "abk"),
  ADY("Adyghe", "ady"),
  AFK("Afrikaans", "afr"),
  AFR("Afar", "aar"),
  AGW("Agaw", "ahg"),
  ALS("Alsatian", "gsw"),
  ALT("Altai", "atv,alt"),
  AMH("Amharic", "amh"),
  APPH("Phonetic transcription—Americanist conventions", ""),
  ARA("Arabic", "ara"),
  ARI("Aari", "aiw"),
  ARK("Arakanese", "mhv,rmz,rki"),
  ASM("Assamese", "asm"),
  ATH("Athapaskan",
      "apk,apj,apl,apm,apw,nav,bea,sek,bcr,caf,crx,clc,gwi,haa,chp,dgr,scs,xsl,srs,ing,hoi,koy,hup,ktw,mvb,wlk,coq,ctc,gce,tol,tuu,kkz,tgx,tht,aht,tfn,taa,tau,tcb,kuu,tce,ttm,txc"),
  AVR("Avar", "ava"),
  AWA("Awadhi", "awa"),
  AYM("Aymara", "aym"),
  AZE("Azeri", "aze"),
  BAD("Badaga", "bfq"),
  BAG("Baghelkhandi", "bfy"),
  BAL("Balkar", "krc"),
  BAU("Baule", "bci"),
  BBR("Berber", ""),
  BCH("Bench", "bcq"),
  BCR("Bible Cree", ""),
  BEL("Belarussian", "bel"),
  BEM("Bemba", "bem"),
  BEN("Bengali", "ben"),
  BGR("Bulgarian", "bul"),
  BHI("Bhili", "bhi,bhb"),
  BHO("Bhojpuri", "bho"),
  BIK("Bikol", "bik"),
  BIL("Bilen", "byn"),
  BKF("Blackfoot", "bla"),
  BLI("Balochi", "bal"),
  BLN("Balante", "bjt,ble"),
  BLT("Balti", "bft"),
  BMB("Bambara", "bam"),
  BML("Bamileke", ""),
  BOS("Bosnian", "bos"),
  BRE("Breton", "bre"),
  BRH("Brahui", "brh"),
  BRI("Braj Bhasha", "bra"),
  BRM("Burmese", "mya"),
  BSH("Bashkir", "bak"),
  BTI("Beti", "btb"),
  CAT("Catalan", "cat"),
  CEB("Cebuano", "ceb"),
  CHE("Chechen", "che"),
  CHG("Chaha Gurage", "sgw"),
  CHH("Chattisgarhi", "hne"),
  CHI("Chichewa", "nya"),
  CHK("Chukchi", "ckt"),
  CHN("Chinese -- as seen in win7 kaiu.ttf", "zho"),
  CHP("Chipewyan", "chp"),
  CHR("Cherokee", "chr"),
  CHU("Chuvash", "chv"),
  CMR("Comorian", "swb,wlc,wni,zdj"),
  COP("Coptic", "cop"),
  COS("Corsican", "cos"),
  CRE("Cree", "cre"),
  CRR("Carrier", "crx,caf"),
  CRT("Crimean Tatar", "crh"),
  CSL("Church Slavonic", "chu"),
  CSY("Czech", "ces"),
  DAN("Danish", "dan"),
  DAR("Dargwa", "dar"),
  DCR("Woods Cree", "cwd"),
  DEU("German", "deu"),
  DFLT("default", ""),
  DGR("Dogri", "doi"),
  DHV("Dhivehi", "div"), // deprecated
  DIV("Dhivehi", "div"),
  DJR("Djerma", "dje"),
  DNG("Dangme", "ada"),
  DNK("Dinka", "din"),
  DRI("Dari", "prs"),
  DUN("Dungan", "dng"),
  DZN("Dzongkha", "dzo"),
  EBI("Ebira", "igb"),
  ECR("Eastern Cree", "crj,crl"),
  EDO("Edo", "bin"),
  EFI("Efik", "efi"),
  ELL("Greek", "ell"),
  ENG("English", "eng"),
  ERZ("Erzya", "myv"),
  ESP("Spanish", "spa"),
  ETI("Estonian", "est"),
  EUQ("Basque", "eus"),
  EVK("Evenki", "evn"),
  EVN("Even", "eve"),
  EWE("Ewe", "ewe"),
  FAN("French Antillean", "acf"),
  FAR("Farsi", "fas"),
  FIN("Finnish", "fin"),
  FJI("Fijian", "fij"),
  FLE("Flemish", "vls"),
  FNE("Forest Nenets", "enf"),
  FON("Fon", "fon"),
  FOS("Faroese", "fao"),
  FRA("French", "fra"),
  FRI("Frisian", "fry"),
  FRL("Friulian", "fur"),
  FTA("Futa", "fuf"),
  FUL("Fulani", "ful"),
  GAD("Ga", "gaa"),
  GAE("Gaelic", "gla"),
  GAG("Gagauz", "gag"),
  GAL("Galician", "glg"),
  GAR("Garshuni", ""),
  GAW("Garhwali", "gbm"),
  GEZ("Ge'ez", "gez"),
  GIL("Gilyak", "niv"),
  GMZ("Gumuz", "guk"),
  GON("Gondi", "gon"),
  GRN("Greenlandic", "kal"),
  GRO("Garo", "grt"),
  GUA("Guarani", "grn"),
  GUJ("Gujarati", "guj"),
  HAI("Haitian", "hat"),
  HAL("Halam", "flm"),
  HAR("Harauti", "hoj"),
  HAU("Hausa", "hau"),
  HAW("Hawaiin", "haw"),
  HBN("Hammer-Banna", "amf"),
  HIL("Hiligaynon", "hil"),
  HIN("Hindi", "hin"),
  Mari("High", "HMA     mrj"),
  HND("Hindko", "hno,hnd"),
  HO("Ho", "hoc"),
  HRI("Harari", "har"),
  HRV("Croatian", "hrv"),
  HUN("Hungarian", "hun"),
  HYE("Armenian", "hye"),
  IBO("Igbo", "ibo"),
  IJO("Ijo", "ijc"),
  ILO("Ilokano", "ilo"),
  IND("Indonesian", "ind"),
  ING("Ingush", "inh"),
  INU("Inuktitut", "iku"),
  IPPH("Phonetic transcription—IPA conventions", ""),
  IRI("Irish", "gle"),
  IRT("Irish Traditional", "gle"),
  ISL("Icelandic", "isl"),
  ISM("Inari Sami", "smn"),
  ITA("Italian", "ita"),
  IWR("Hebrew", "heb"),
  JAV("Javanese", "jav"),
  JII("Yiddish", "yid"),
  JAN("Japanese", "jpn"),
  JUD("Judezmo", "lad"),
  JUL("Jula", "dyu"),
  KAB("Kabardian", "kbd"),
  KAC("Kachchi", "kfr"),
  KAL("Kalenjin", "kln"),
  KAN("Kannada", "kan"),
  KAR("Karachay", "krc"),
  KAT("Georgian", "kat"),
  KAZ("Kazakh", "kaz"),
  KEB("Kebena", "ktb"),
  KGE("Khutsuri Georgian", "kat"),
  KHA("Khakass", "kjh"),
  KHK("Khanty-Kazim", "kca"),
  KHM("Khmer", "khm"),
  KHN("Khun(?)", "kkh"),
  KHS("Khanty-Shurishkar", "kca"),
  KHV("Khanty-Vakhi", "kca"),
  KHW("Khowar", "khw"),
  KIK("Kikuyu", "kik"),
  KIR("Kirghiz", "kir"),
  KIS("Kisii", "kqs,kss"),
  KKN("Kokni", "kex"),
  KLM("Kalmyk", "xal"),
  KMB("Kamba", "kam"),
  KMN("Kumaoni", "kfy"),
  KMO("Komo", "kmw"),
  KMS("Komso", "kxc"),
  KNR("Kanuri", "kau"),
  KOD("Kodagu", "kfa"),
  KOH("Korean Old Hangul", "okm"),
  KOK("Konkani", "kok"),
  KON("Kikongo", "ktu"),
  KOP("Komi-Permyak", "koi"),
  KOR("Korean", "kor"),
  KOZ("Komi-Zyrian", "kpv"),
  KPL("Kpelle", "kpe"),
  KRI("Krio", "kri"),
  KRK("Karakalpak", "kaa"),
  KRL("Karelian", "krl"),
  KRM("Karaim", "kdr"),
  KRN("Karen", "kar"),
  KRT("Koorete", "kqy"),
  KSH("Kashmiri", "kas"),
  KSI("Khasi", "kha"),
  KSM("Kildin Sami", "sjd"),
  KUI("Kui", "kxu"),
  KUL("Kulvi", "kfx"),
  KUM("Kumyk", "kum"),
  KUR("Kurdish", "kur"),
  KUU("Kurukh", "kru"),
  KUY("Kuy", "kdt"),
  KYK("Koryak", "kpy"),
  LAD("Ladin", "lld"),
  LAH("Lahuli", "bfu"),
  LAK("Lak", "lbe"),
  LAM("Lambani", "lmn"),
  LAO("Lao", "lao"),
  LAT("Latin", "lat"),
  LAZ("Laz", "lzz"),
  LCR("L-Cree", "crm"),
  LDK("Ladakhi", "lbj"),
  LEZ("Lezgi", "lez"),
  LIN("Lingala", "lin"),
  LMA("Low Mari", "mhr"),
  LMB("Limbu", "lif"),
  LMW("Lomwe", "ngl"),
  LSB("Lower Sorbian", "dsb"),
  LSM("Lule Sami", "smj"),
  LTH("Lithuanian", "lit"),
  LTZ("Luxembourgish", "ltz"),
  LUB("Luba", "lua,lub"),
  LUG("Luganda", "lug"),
  LUH("Luhya", "luy"),
  LUO("Luo", "luo"),
  LVI("Latvian", "lav"),
  MAJ("Majang", "mpe"),
  MAK("Makua", "vmw"),
  MAL("Malayalam Traditional", "mal"),
  MAN("Mansi", "mns"),
  MAP("Mapudungun", "arn"),
  MAR("Marathi", "mar"),
  MAW("Marwari", "mwr"),
  MBN("Mbundu", "kmb"),
  MCH("Manchu", "mnc"),
  MCR("Moose Cree", "crm"),
  MDE("Mende", "men"),
  MEN("Me'en", "mym"),
  MIZ("Mizo", "lus"),
  MKD("Macedonian", "mkd"),
  MLE("Male", "mdy"),
  MLG("Malagasy", "mlg"),
  MLN("Malinke", "mlq"),
  MLR("Malayalam Reformed", "mal"),
  MLY("Malay", "msa"),
  MND("Mandinka", "mnk"),
  MNG("Mongolian", "mon"),
  MNI("Manipuri", "mni"),
  MNK("Maninka", "man"),
  MNX("Manx Gaelic", "glv"),
  MOH("Mohawk", "moh"),
  MOK("Moksha", "mdf"),
  MOL("Moldavian", "mol"),
  MON("Mon", "mnw"),
  MOR("Moroccan", ""),
  MRI("Maori", "mri"),
  MTH("Maithili", "mai"),
  MTS("Maltese", "mlt"),
  MUN("Mundari", "unr"),
  NAG("Naga-Assamese", "nag"),
  NAN("Nanai", "gld"),
  NAS("Naskapi", "nsk"),
  NCR("N-Cree", "csw"),
  NDB("Ndebele", "nbl,nde"),
  NDG("Ndonga", "ndo"),
  NEP("Nepali", "nep"),
  NEW("Newari", "new"),
  NGR("Nagari", ""),
  NHC("Norway House Cree", "csw"),
  NIS("Nisi", "dap"),
  NIU("Niuean", "niu"),
  NKL("Nkole", "nyn"),
  NKO("N'Ko", "nqo"),
  NLD("Dutch", "nld"),
  NOG("Nogai", "nog"),
  NOR("Norwegian", "nob"),
  NSM("Northern Sami", "sme"),
  NTA("Northern Tai", "nod"),
  NTO("Esperanto", "epo"),
  NYN("Nynorsk", "nno"),
  OCI("Occitan", "oci"),
  OCR("Oji-Cree", "ojs"),
  OJB("Ojibway", "oji"),
  ORI("Odia (formerly Oriya)", "ori"),
  ORO("Oromo", "orm"),
  OSS("Ossetian", "oss"),
  PAA("Palestinian Aramaic", "sam"),
  PAL("Pali", "pli"),
  PAN("Punjabi", "pan"),
  PAP("Palpa", "plp"),
  PAS("Pashto", "pus"),
  PGR("Polytonic Greek", "ell"),
  PIL("Filipino", "fil"),
  PLG("Palaung", "pce,rbb,pll"),
  PLK("Polish", "pol"),
  PRO("Provencal", "pro"),
  PTG("Portuguese", "por"),
  QIN("Chin",
      "bgr,cnh,cnw,czt,sez,tcp,csy,ctd,flm,pck,tcz,zom,cmr,dao,hlt,cka,cnk,mrh,mwg,cbl,cnb,csh"),
  RAJ("Rajasthani", "raj"),
  RCR("R-Cree", "atj"),
  RBU("Russian Buriat", "bxr"),
  RIA("Riang", "ria"),
  RMS("Rhaeto-Romanic", "roh"),
  ROM("Romanian", "ron"),
  ROY("Romany", "rom"),
  RSY("Rusyn", "rue"),
  RUA("Ruanda", "kin"),
  RUS("Russian", "rus"),
  SAD("Sadri", "sck"),
  SAN("Sanskrit", "san"),
  SAT("Santali", "sat"),
  SAY("Sayisi", "chp"),
  SEK("Sekota", "xan"),
  SEL("Selkup", "sel"),
  SGO("Sango", "sag"),
  SHN("Shan", "shn"),
  SIB("Sibe", "sjo"),
  SID("Sidamo", "sid"),
  SIG("Silte Gurage", "xst"),
  SKS("Skolt Sami", "sms"),
  SKY("Slovak", "slk"),
  SLA("Slavey", "scs"),
  SLV("Slovenian", "slv"),
  SML("Somali", "som"),
  SMO("Samoan", "smo"),
  SNA("Sena", "she"),
  SND("Sindhi", "snd"),
  SNH("Sinhalese", "sin"),
  SNK("Soninke", "snk"),
  SOG("Sodo Gurage", "gru"),
  SOT("Sotho", "nso,sot"),
  SQI("Albanian", "sqi"),
  SRB("Serbian", "srp"),
  SRK("Saraiki", "skr"),
  SRR("Serer", "srr"),
  SSL("South Slavey", "xsl"),
  SSM("Southern Sami", "sma"),
  SUR("Suri", "suq"),
  SVA("Svan", "sva"),
  SVE("Swedish", "swe"),
  SWA("Swadaya Aramaic", "aii"),
  SWK("Swahili", "swa"),
  SWZ("Swazi", "ssw"),
  SXT("Sutu", "ngo"),
  SYR("Syriac", "syr"),
  TAB("Tabasaran", "tab"),
  TAJ("Tajiki", "tgk"),
  TAM("Tamil", "tam"),
  TAT("Tatar", "tat"),
  TCR("TH-Cree", "cwd"),
  TEL("Telugu", "tel"),
  TGN("Tongan", "ton"),
  TGR("Tigre", "tig"),
  TGY("Tigrinya", "tir"),
  THA("Thai", "tha"),
  THT("Tahitian", "tah"),
  TIB("Tibetan", "bod"),
  TKM("Turkmen", "tuk"),
  TMN("Temne", "tem"),
  TNA("Tswana", "tsn"),
  TNE("Tundra Nenets", "enh"),
  TNG("Tonga", "toi"),
  TOD("Todo", "xal"),
  TRK("Turkish", "tur"),
  TSG("Tsonga", "tso"),
  TUA("Turoyo Aramaic", "tru"),
  TUL("Tulu", "tcy"),
  TUV("Tuvin", "tyv"),
  TWI("Twi", "aka"),
  UDM("Udmurt", "udm"),
  UKR("Ukrainian", "ukr"),
  URD("Urdu", "urd"),
  USB("Upper Sorbian", "hsb"),
  UYG("Uyghur", "uig"),
  UZB("Uzbek", "uzb"),
  VEN("Venda", "ven"),
  VIT("Vietnamese", "vie"),
  WA("Wa", "wbm"),
  WAG("Wagdi", "wbr"),
  WCR("West-Cree", "crk"),
  WEL("Welsh", "cym"),
  WLF("Wolof", "wol"),
  XBD("Tai Lue", "khb"),
  XHS("Xhosa", "xho"),
  YAK("Sakha", "sah"),
  YBA("Yoruba", "yor"),
  YCR("Y-Cree", ""),
  YIC("Yi Classic", ""),
  YIM("Yi Modern", "iii"),
  ZHH("Chinese, Hong Kong SAR", "zho"),
  ZHP("Chinese Phonetic", "zho"),
  ZHS("Chinese Simplified", "zho"),
  ZHT("Chinese Traditional", "zho"),
  ZND("Zande", "zne"),
  ZUL("Zulu", "zul"),
  de("German found in FreeSerif.ttf", "deu"),
  nl("Dutch found in FreeSansBoldOblique.ttf", "nld"),
  tmh("Tamashek found in ebrimabd.ttf", "tmh");

  private LanguageTag(String name, String iso3List) {
    String tag = name();
    while (tag.length() < 4) {
      tag += ' ';
    }
    this.tag = Tag.intValue(tag);
    this.name = name;
    this.iso3List = iso3List;
  }

  public int tag() {
    return tag;
  }

  public String longName() {
    return name;
  }

  public boolean isDeprecated() {
    return this == DHV;
  }

  public List<String> iso3List() {
    return Arrays.asList(iso3List.split(","));
  }

  static LanguageTag fromTag(int tag) {
    for (LanguageTag script : LanguageTag.values()) {
      if (script.tag == tag) {
        return script;
      }
    }
    throw new IllegalArgumentException(Tag.stringValue(tag));
  }

  private final int tag;
  private final String name;
  private final String iso3List;
}
