package com.das.biz.model.geo;

import com.das.biz.model.location.LocationVO;

public interface GeoService {
	LocationVO getAddress(LocationVO alvo);
	LocationVO getLocation(LocationVO alvo);
}
