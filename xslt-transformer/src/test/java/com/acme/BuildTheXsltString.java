/*
 *
 * Copyright (c) 2015 Pivotal Software, Inc. All Rights Reserved
 *
 * This software contains the intellectual property of Pivotal Software, Inc. or is
 * licensed to Pivotal Software, Inc. from third parties. Use of this software and
 * the intellectual property contained therein is expressly limited to the
 * terms and conditions of the License Agreement under which it is provided
 * by or on behalf of Pivotal Software, Inc.
 */

package com.acme;

import org.junit.Test;

/**
 * @author Muhammad Ali
 */
public class BuildTheXsltString {

	@Test
	public void test() {
	/*|	String str = "ID,AWB,Origin,Destination,BeyondOrigin,BeyondDestination,OriginLocationCode,DestinationLocationCode,ProductGroup,Type,Services,Skeleton,ForeignHAWBNumber,CollectionReference,PickupDate,PickupBy,ReceivedAt,PCS,Weight,Unit,ChargingWeight,HAWBDimensions,CommodityCountryCode,CommodityDescription,CMT,PaymentType,SRNNo,Customs,CollectAmount,CustomsCurrency,CollectCurrency,CashValue,CashCurrency,InsuranceValue,InsuranceCurrency,CODValue,CODCurrency,AdditionalAmtDescription,ShipperNumber,ShipperReference,ShipperReference2,ShipperName,SentBy,ShipperAddress,ShipperTel,ShipperFax,ShipperEmail,ShipperID,ShipperTeamID,PrepaidRangeID,OriginCity,OriginState,OriginZipCode,OriginCountry,ConsigneeNumber,ConsigneeReference,ConsigneeReference2,ConsigneeName,AttnOf,ConsigneeAddress,ConsigneeTel,ConsigneeFax,ConsigneeEmail,ConsigneeID,ConsigneeTeamID,DestCity,DestState,DestZipCode,DestCountry,ThirdParty,ThirdPartyNumber,ThirdPartyReference,ThirdPartyReference2,ThirdPartyName,ThirdPartyAddress,ThirdPartyTel,ThirdPartyCity,ThirdPartyState,ThirdPartyZip,ThirdPartyCountry,ThirdPartyID,ThirdPartyTeamID,Reference1,Reference2,Reference3,Remarks,AlertedBy,AlertedDate,SourceID,TS,Cube,CubeUnit,DueDate,AccountingInformation,HandlingInformation,Scheme,ShipperTel2,ShipperMobile,ConsigneeTel2,ConsigneeMobile,ThirdPartyTel2,ThirdPartyMobile,CustomsStatus";
		String values = "1002,OLV80UJS7YO,Sai,Den,5,5,ant,eni,a  ,fri,dapibus quam quis diam. P,1,OZI42FSX8JA,VTV17WR,2014-05-28 02:13:00.0,Fuller Fulton,1752,40,89.0,Ma,75.0,N,Bh,\"est, congue a, aliquet vel, vulputate eu, odio. Phasellus at\",m,lore,ante,750.0,183.0,arc,sap,820.0,ac ,427.0,Viv,671.0,nec,Cras sed leo. Cras vehicula,venenatis,egestas. Aliquam fringilla cursus purus. Nullam scelerisque neque sed sem,Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc,Gil E. Rich,Fredericka Paul,\"P.O. Box 661, 187 Donec Av.\",07624 026486,07624 107595,pede.nec.ante@egetlacus.co.uk,160,154,359,Castelló,CV,2861,Je,890,\"Cum sociis natoque penatibus et magnis dis parturient montes, nascetur\",\"ac tellus. Suspendisse sed dolor. Fusce mi lorem, vehicula et,\",Jenna Sandoval,Callie F. Pugh,\"897-9171 Leo, Avenue\",0847 902 4434,(014110) 30534,dictum@mauris.co.uk,58,824,Valéncia,QC,61157,Be,par,Etiam,\"ante lectus convallis est, vitae sodales nisi magna sed dui.\",scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia.,Xantha Cleveland,\"P.O. Box 345, 7364 Pede, Rd.\",0915 082 4749,Valéncia,Assam,32144,Li,853,271,\"Nullam scelerisque neque sed sem egestas blandit. Nam nulla magna,\",vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac,\"Nulla eget metus eu erat semper rutrum. Fusce dolor quam,\",metus. Vivamus euismod urna. Nullam lobortis quam a felis ullamcorper,Andrew,2014-09-26 17:43:00.0,8,2015-08-25 19:50:00.0,866.0,ege,2014-09-10 01:38:00.0,\"nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis\",\"sit amet, risus. Donec nibh enim, gravida sit amet, dapibus\",41,07624 067408,055 7573 6640,0500 078945,(016977) 6958,(01890) 97822,(0121) 076 7840,sagittis.";
		String[] valueList = values.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		
		System.out.println( valueList.length );
		
		String [] all = str.split(",");
		List<String> splittStrings = Arrays.asList(all);
		StringBuilder finalStr = new StringBuilder();
		StringBuilder xsltStr = new StringBuilder();
		
		String suffix = "\"/><xsl:text>,</xsl:text>";
		String prefix = "<xsl:value-of select=\"";
		
		
		
		IntStream.range(0, splittStrings.size()).forEach(index->
		{
			String single = splittStrings.get(index);
			xsltStr.append(prefix);
			xsltStr.append(single);
			xsltStr.append(suffix);
			xsltStr.append("\r\n");
			
			finalStr.append("<"+single+">");
			finalStr.append(valueList[index]);
			finalStr.append("</"+single+">");
		});
		
		System.out.println(finalStr);
		System.out.println(xsltStr);*/
	}

}

