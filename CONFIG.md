# Configuration Guide / コンフィグ設定ガイド

[English](#english) | [日本語](#日本語-japanese)

---

## English

Configuration file location: `config/aiming_to_become_a_legend_iss-server.toml` (generated inside world save or server config directory).

### Settings: `[iss_attribute_bonuses]`

| Parameter Name | Data Type | Default Value | Min Value | Max Value | Description |
| :--- | :--- | :--- | :--- | :--- | :--- |
| `manaRegenPerTier` | Double | `0.05` | `0.0` | `100.0` | Mana regeneration multiplier bonus per tier (`0.05` = +5%). |
| `spellPowerPerTier` | Double | `0.05` | `0.0` | `100.0` | Global spell power multiplier bonus per tier (`0.05` = +5%). |
| `maxManaPerTier` | Double | `20.0` | `0.0` | `100000.0` | Flat maximum mana increase per tier (+20 max mana). |
| `cooldownReductionPerTier` | Double | `0.05` | `0.0` | `10.0` | Spell cooldown reduction multiplier bonus per tier (`0.05` = +5%). |
| `castTimeReductionPerTier` | Double | `0.05` | `0.0` | `10.0` | Spell cast time reduction multiplier bonus per tier (`0.05` = +5%). |
| `spellResistPerTier` | Double | `0.01` | `0.0` | `1.0` | Spell resistance multiplier bonus per tier (`0.01` = +1%). |

---

## 日本語 (Japanese)

コンフィグファイルの生成場所: `config/aiming_to_become_a_legend_iss-server.toml` (ワールドセーブ内またはサーバー設定フォルダ)。

### 設定項目一覧: `[iss_attribute_bonuses]`

| 設定項目名 | データ型 | デフォルト値 | 最小値 | 最大値 | 詳細解説 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| `manaRegenPerTier` | 小数 (Double) | `0.05` | `0.0` | `100.0` | 段階(Tier)ごとに獲得するマナ再生倍率ボーナス (`0.05` = +5%)。 |
| `spellPowerPerTier` | 小数 (Double) | `0.05` | `0.0` | `100.0` | 段階(Tier)ごとに獲得する全体魔法威力倍率ボーナス (`0.05` = +5%)。 |
| `maxManaPerTier` | 小数 (Double) | `20.0` | `0.0` | `100000.0` | 段階(Tier)ごとに獲得する最大マナプール加算ボーナス (+20 マナ)。 |
| `cooldownReductionPerTier` | 小数 (Double) | `0.05` | `0.0` | `10.0` | 段階(Tier)ごとに獲得する魔法クールダウン短縮倍率ボーナス (`0.05` = +5%)。 |
| `castTimeReductionPerTier` | 小数 (Double) | `0.05` | `0.0` | `10.0` | 段階(Tier)ごとに獲得する魔法詠唱時間短縮倍率ボーナス (`0.05` = +5%)。 |
| `spellResistPerTier` | 小数 (Double) | `0.01` | `0.0` | `1.0` | 段階(Tier)ごとに獲得する魔法耐性倍率ボーナス (`0.01` = +1%)。 |
